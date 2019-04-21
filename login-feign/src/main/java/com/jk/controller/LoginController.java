/**
 * Copyright (C),2019, 金科教育
 * FileName: loginController
 * Author:   马法冲
 * Date:     2019/4/16 20:25
 * Description: a
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller;

import com.jk.service.LoginServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * 〈一句话功能简述〉<br> 
 * 〈a〉
 *
 * @author MC
 * @create 2019/4/16
 * @since 1.0.0
 */
@RestController
public class LoginController {

    @Autowired
    private LoginServiceFeign loginServiceFeign;

    @Resource
    private RedisTemplate redisTemplate;

    //个人登录
    @GetMapping("toLogin")
    public HashMap<String,Object> toLoginByAccount(@RequestParam("account")String account, @RequestParam("password")String password){
        HashMap<String,Object> param = loginServiceFeign.toLogin(account,password);
        return param;
    }
    //企业登录
    @GetMapping("qylogin")
    public HashMap<String,Object> qylogin(@RequestParam("haccount")String haccount, @RequestParam("hpassword")String hpassword){
        HashMap<String,Object> params = loginServiceFeign.qylogin(haccount,hpassword);
        return params;
    }

    //获取验证码
    @GetMapping("clickPassword")
    public HashMap<String, Object> findPhonePassword(@RequestParam("userPhone") String userPhone){
        return loginServiceFeign.findPhonePassword(userPhone);
    }
    //注册获取验证码
    @GetMapping("clickRefPassword")
    public HashMap<String, Object> clickRefPassword(@RequestParam("userPhone") String userPhone){
        return loginServiceFeign.findRefPassword(userPhone);
    }
    //修改密码获取验证码
    @GetMapping("findUpdPassword")
    public HashMap<String, Object> findUpdPassword(@RequestParam("userPhone") String userPhone){
        return loginServiceFeign.findRefPassword(userPhone);
    }

    //注册
    @GetMapping("refUser")
    public HashMap<String,Object> refUsers(@RequestParam("userPhone")String userPhone,@RequestParam("yzpassword")String yzpassword,@RequestParam("password")String password){
        HashMap<String,Object> param = new HashMap<>();
        String key = "ref"+userPhone;
        Object yzm1 = redisTemplate.opsForValue().get(key);
        String yzm = String.valueOf(yzm1);

        if(!yzpassword.equals(yzm)){
            param.put("msg","验证码错误!");
            param.put("code",1);
            return param;
        }
        int count = loginServiceFeign.findUserByuserPhone(userPhone);
        if(count!=0){
            param.put("msg","该账号已存在!");
            param.put("code",2);
            return param;
        }
        loginServiceFeign.saveLoginAccount(userPhone,password);
        redisTemplate.delete(key);
        param.put("msg","注册成功!");
        param.put("code",0);
        return param;
    }
    //修改密码
    @GetMapping("updateUserByPassword")
    public HashMap<String, Object> updateUserByPassword(@RequestParam("userPhone")String userPhone,@RequestParam("yzpassword")String yzpassword,@RequestParam("password")String password){
        HashMap<String,Object> params = new HashMap<>();
        String key = "ref"+userPhone;
        Object yzm1 = redisTemplate.opsForValue().get(key);
        String yzm = String.valueOf(yzm1);
        if(!yzpassword.equals(yzm)){
            params.put("msg","验证码错误!");
            params.put("code",1);
            return params;
        }
        Boolean boo= loginServiceFeign.updateUserByPassword(userPhone,password);
        if(boo==true){
            redisTemplate.delete(key);
            params.put("msg","修改成功!");
            params.put("code",0);
            return params;
        }else{
            params.put("msg","修改失败!");
            params.put("code",2);
            return params;
        }
    }




}