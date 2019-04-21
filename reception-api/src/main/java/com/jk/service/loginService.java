package com.jk.service;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

public interface loginService {

    //个人登录
    @GetMapping("toLogin")
    @ResponseBody
    HashMap<String, Object> toLogin(@RequestParam("account")String account, @RequestParam("password")String password);

    //获取验证码
    @GetMapping("findPhonePassword")
    @ResponseBody
    HashMap<String, Object> findPhonePassword(@RequestParam("userPhone") String userPhone);

    //注册
    @GetMapping("saveLoginAccount")
    @ResponseBody
    void saveLoginAccount(@RequestParam("userPhone")String userPhone, @RequestParam("password")String password);

    //判断手机号是否存在
    @GetMapping("findUserByuserPhone")
    @ResponseBody
    int findUserByuserPhone(@RequestParam("userPhone")String userPhone);

    //注册获取验证码
    @GetMapping("findRefPassword")
    @ResponseBody
    HashMap<String, Object> findRefPassword(@RequestParam("userPhone")String userPhone);

    //企业登录
    @GetMapping("qylogin")
    @ResponseBody
    HashMap<String, Object> qylogin(@RequestParam("haccount")String haccount, @RequestParam("hpassword")String hpassword);

    //修改密码
    @GetMapping("updateUserByPassword")
    @ResponseBody
    Boolean updateUserByPassword(@RequestParam("userPhone")String userPhone, @RequestParam("password")String password);
}
