package com.jk.controller;

import com.jk.model.SpikeBean;
import com.jk.model.UserBean;
import com.jk.model.WebShoppingcCart;
import com.jk.service.HomeServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@RestController
public class CenterController {

    @Autowired
    private HomeServiceFeign homeServiceFeign;

    @Autowired
    private RedisTemplate redisTemplate;

    //回显用户信息
    @GetMapping("findByIdUser")
    public UserBean findByIdUser(@RequestParam("userId") Integer userId){

        UserBean chaxun= homeServiceFeign.findByIdUser(userId);
        System.out.println(chaxun);

        return chaxun;
    }

    //修改用户信息
    @PutMapping("updateUser")
    public void updateUser(@RequestBody UserBean user){

        homeServiceFeign.updateUser(user);
    }

    //查询秒杀商品
    @GetMapping("querySeckill")
    @ResponseBody
    public List<SpikeBean> querySeckill() {
        String key = "listbs";
        List<SpikeBean>list = new ArrayList<>();
        if (!redisTemplate.hasKey(key)) {
            list = homeServiceFeign.querySeckill();
            redisTemplate.opsForValue().set(key, list);
            redisTemplate.expire(key, 7, TimeUnit.DAYS);
        } else {
            list = (List<SpikeBean>)redisTemplate.opsForValue().get(key);
        }
        return list;
    }

    //秒杀商品加购物车
    @PostMapping("addSeckill")
    @ResponseBody
    public void addSeckill(){
        WebShoppingcCart cart=new WebShoppingcCart();

        homeServiceFeign.addSeckill(cart);
    }
    //计时器
    @RequestMapping("jishiqi")
    public String jiShiQi(){
        return "jishiqi";
    }
    //查询时间
    @RequestMapping("jishi")
    @ResponseBody
    public Map<String,Object> jishiq() throws ParseException {
        HashMap<String,Object> params = new HashMap<>();
        List<SpikeBean> list = homeServiceFeign.findSeckillDate();
        for (int i = 0;i<1;i++){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String aaa = list.get(1).getStartDate().toString();
            Date time = new Date(aaa);
            String date = sdf.format(time);
            System.out.println(date);

            Date dangq= new Date();
            String dangqian = sdf.format(dangq);

            params.put("start",date);
            params.put("dq",dangqian);
        }
        return params;
    }
}
