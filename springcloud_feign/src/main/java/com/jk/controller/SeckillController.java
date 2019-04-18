package com.jk.controller;


import com.jk.model.SpikeBean;
import com.jk.service.SeckillService;
import com.jk.service.SeckillServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class SeckillController {

    @Autowired
    private SeckillServiceFeign seckillServiceFeign;

    @GetMapping("querySeckill")
    @ResponseBody
    public List<SpikeBean> querySeckill(){
        List list = seckillServiceFeign.querySeckill();
        return  list;

    }

}
