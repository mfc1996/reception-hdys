/**
 * Copyright (C),2019, 金科教育
 * FileName: PageController
 * Author:   马法冲
 * Date:     2019/4/17 11:15
 * Description: a
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 〈一句话功能简述〉<br> 
 * 〈a〉
 *
 * @author MC
 * @create 2019/4/17
 * @since 1.0.0
 */
@RequestMapping("page")
@Controller
public class PageController {

    //跳转登录页面
    @RequestMapping("login")
    public String toLogin(){
        return "login";
    }
    //跳转登录页面2
    @RequestMapping("toLogin")
    public String toLogin2(){
        return "toLogin";
    }
    //跳转注册页面2
    @RequestMapping("toRef")
    public String ref1(){
        return "ref";
    }
    //跳转修改密码页面
    @RequestMapping("updPassword")
    public String updatePassword(){
        return "updatePassword";
    }
    //客服弹框
    @RequestMapping("toRobot")
    public String toRobots(){
        return "robot";
    }
}