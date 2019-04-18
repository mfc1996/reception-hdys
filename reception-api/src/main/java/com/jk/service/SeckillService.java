package com.jk.service;


import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


public interface SeckillService {



    @GetMapping("querySeckill")
    @ResponseBody
    List querySeckill();
   
}
