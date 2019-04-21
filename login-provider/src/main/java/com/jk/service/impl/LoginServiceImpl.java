/**
 * Copyright (C),2019, 金科教育
 * FileName: LoginServiceImpl
 * Author:   马法冲
 * Date:     2019/4/17 8:54
 * Description: a
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jk.mapper.LoginMapper;
import com.jk.model.User;
import com.jk.service.loginService;
import com.jk.util.HttpClientUtil;
import com.jk.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br> 
 * 〈a〉
 *
 * @author MC
 * @create 2019/4/17
 * @since 1.0.0
 */
@Controller
public class LoginServiceImpl implements loginService {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private LoginMapper loginMapper;

    //企业登录
    @ResponseBody
    @Override
    public HashMap<String, Object> qylogin(@RequestParam("haccount") String haccount, @RequestParam("hpassword") String hpassword) {
        HashMap<String, Object> hah = new HashMap<>();
        User users = loginMapper.qylogin(haccount);

        if (users == null) {
            hah.put("codes", 2);
            hah.put("msgs", "账号输入有误");
            return hah;
        }
        System.out.println("++++++++++企业登录"+users.getRoleId());
        if(users.getRoleId().equals("4")||users.getRoleId().equals("5")||users.getRoleId().equals("6")){
            hah.put("codes", 4);
            hah.put("msgs", "账号输入有误1");
            return hah;
        }
        String usersPassword = users.getUserPassword();
        String md516s = Md5Util.getMd516(usersPassword);
        if (!users.getUserPassword().equals(hpassword)) {
            hah.put("codes", 3);
            hah.put("msgs", "密码输入有误");
            return hah;
        }
        hah.put("codes", 0);
        hah.put("msgs", "登陆成功");
        return hah;
    }

    //修改密码
    @ResponseBody
    @Override
    public Boolean updateUserByPassword(@RequestParam("userPhone")String userPhone, @RequestParam("password")String password) {
        String userPassword= Md5Util.getMd516(password);
        System.out.println("修改密码账号-----"+userPhone);
        System.out.println("修改密码密码-----"+userPassword);
        loginMapper.updateUserByPassword(userPhone,userPassword);
        return true;
    }

    //个人登录
    @ResponseBody
    @Override
    public HashMap<String, Object> toLogin(@RequestParam("account") String account, @RequestParam("password") String password) {
        System.out.println("个人登录账号"+account);
        HashMap<String, Object> result = new HashMap<>();
        User user = loginMapper.toLogin(account);
        System.out.println("个人------------------------"+user.getRoleId());
        if (user == null) {
            result.put("code", 2);
            result.put("msg", "账号输入有误");
            return result;
        }
        String roleIds = String.valueOf(user.getRoleId());
        if(user.getRoleId().equals("1")||user.getRoleId().equals("2")||user.getRoleId().equals("3")){
            result.put("code", 4);
            result.put("msg", "账号输入有误");
            return result;
        }
        String userPassword = user.getUserPassword();
        String md516 = Md5Util.getMd516(password);
        if (!user.getUserPassword().equals(password)) {
            result.put("code", 3);
            result.put("msg", "密码输入有误");
            return result;
        }
        result.put("code", 0);
        result.put("msg", "登陆成功");
        return result;
    }


    //登录获取验证码
    @ResponseBody
    @Override
    public HashMap<String, Object> findPhonePassword(@RequestParam("userPhone") String userPhone) {
        HashMap<String, Object> results = new HashMap<>();
        System.out.println("************123" + userPhone);
        User user = loginMapper.findUserPhone(userPhone);
        if (user == null) {
            results.put("code", 1);
            results.put("msg", "账号不存在");
            return results;
        }
        String url = "https://openapi.miaodiyun.com/distributor/sendSMS";
        HashMap<String, Object> params = new HashMap<>();
        String accountSid = "9eca25a6d7624d0cb80e7e9e8a2cc395";
        params.put("accountSid", accountSid);//开发者主账号ID（ACCOUNT SID）
        params.put("templateid", "1575609976");//短信模板ID
        //6位随机数，验证码
        int code = (int) Math.ceil(Math.random()*899999+100000);
        //存验证码
        String key = "msgcode"+userPhone;
        redisTemplate.opsForValue().set(key, code, 5, TimeUnit.MINUTES);
        System.out.println(code);
        //String codeStr = String.valueOf(code);
        params.put("param", code);//短信模板中的变量值
        params.put("to", userPhone);//手机号
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = sdf.format(new Date());
        System.out.println("+++++++++++++++"+time);
        params.put("timestamp",time);//时间戳
        String token = "51d8ffb9354146f685500f107beab1aa";
        String sig = Md5Util.getMd532(accountSid+token+time);
        params.put("sig", sig);//签名
        //发送短信
        String returnStr = HttpClientUtil.post(url, params);
        System.out.println("...." + returnStr);
        JSONObject parseObject = JSON.parseObject(returnStr);
        String respCode = parseObject.getString("respCode");
        if(!respCode.equals("00000")){
            System.out.println("************" + respCode);
            results.put("code", 2);
            results.put("msg", "发送短信验证码失败");
            return results;
        }

        results.put("code", 0);
        results.put("msg", "发送短信验证码成功");
        return results;
    }

    //注册
    @ResponseBody
    @Override
    public void saveLoginAccount(@RequestParam("userPhone")String userPhone, @RequestParam("password")String password) {
        String userPassword= Md5Util.getMd516(password);
        User user = new User();
        user.setUserAccount(userPhone);
        user.setUserPassword(userPassword);
        loginMapper.saveLoginAccount(user);
        int id = user.getUserId();
        loginMapper.saveUserRole(id);
    }

    //判断手机号是否存在
    @ResponseBody
    @Override
    public int findUserByuserPhone(@RequestParam("userPhone")String userPhone) {
        return loginMapper.findUserByuserPhone(userPhone);
    }

    //注册验证码
    @ResponseBody
    @Override
    public HashMap<String, Object> findRefPassword(@RequestParam("userPhone")String userPhone) {
        HashMap<String, Object> results = new HashMap<>();
        System.out.println("************注册" + userPhone);
        /*String url = "https://openapi.miaodiyun.com/distributor/sendSMS";
        HashMap<String, Object> params = new HashMap<>();
        String accountSid = "9eca25a6d7624d0cb80e7e9e8a2cc395";
        params.put("accountSid", accountSid);//开发者主账号ID（ACCOUNT SID）
        params.put("templateid", "1575609976");//短信模板ID*/
        //6位随机数，验证码
        int codes = (int) Math.ceil(Math.random()*899999+100000);
        System.out.println("************注册"+codes);
        //存验证码
        String key = "ref"+userPhone;
        redisTemplate.opsForValue().set(key, codes, 5, TimeUnit.MINUTES);
       //String codeStr = String.valueOf(code);
       /* params.put("param", code);//短信模板中的变量值
        params.put("to", userPhone);//手机号
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = sdf.format(new Date());
        System.out.println("+++++++++++++++"+time);
        params.put("timestamp",time);//时间戳
        String token = "51d8ffb9354146f685500f107beab1aa";
        String sig = Md5Util.getMd532(accountSid+token+time);
        params.put("sig", sig);//签名
        //发送短信
        String returnStr = HttpClientUtil.post(url, params);
        System.out.println("...." + returnStr);
        JSONObject parseObject = JSON.parseObject(returnStr);
        String respCode = parseObject.getString("respCode");
        if(!respCode.equals("00000")){
            System.out.println("************" + respCode);
            results.put("code", 2);
            results.put("msg", "发送短信验证码失败");
            return results;
        }*/
        results.put("code", 0);
        results.put("msg", "发送短信验证码成功");
        return results;
    }
}
