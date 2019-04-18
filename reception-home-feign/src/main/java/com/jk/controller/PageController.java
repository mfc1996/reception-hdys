package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    /**
     * 跳转到首页面
     * @return
     */
    @RequestMapping("toHomePage")
    public String toHomePage(){
        return "homepage";
    }

}
