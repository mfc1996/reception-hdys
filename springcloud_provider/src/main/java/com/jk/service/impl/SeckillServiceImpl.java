package com.jk.service.impl;



import com.jk.mapper.SeckillMapper;
import com.jk.model.SpikeBean;
import com.jk.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
@Controller
public class SeckillServiceImpl implements SeckillService {

    @Autowired
    private SeckillMapper seckillMapper;


    @Override
    public List querySeckill() {

        return seckillMapper.querySeckill();
    }
}
