/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: chanpinController
 * Author:   郭晨凯
 * Date:     2019-04-17 16:20
 * Description: gck
 * History:
 * 郭晨凯        <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller;

import com.jk.model.Product;
import com.jk.model.WebShoppingcCart;
import com.jk.service.HomeServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

/**
 * 〈购物车支付流程，沙箱操作，购物车信息缓存redis，生成订单存mysql〉<br>
 * 〈gck〉
 *
 * @author chenkai
 * @create 2019-04-17
 * @since 1.0.0
 */
@Controller
public class chanpinController {

    @Autowired
    private HomeServiceFeign homeServiceFeign;

    @Autowired
    private RedisTemplate redisTemplate;

    //*添加购物车*//*
    @ResponseBody
    @RequestMapping("addCar")
    public void addCar(Integer spid, HttpServletRequest request, HttpServletResponse response, Integer sl) throws UnsupportedEncodingException {
        Product pro = homeServiceFeign.queryProductByIds(spid);

        WebShoppingcCart cp = new WebShoppingcCart();
        String key ="keys"+"70";
        cp.setGoodsId(pro.getProductId());
        cp.setGoodsName(pro.getProductName());
        cp.setGoodsPrice(50);
        cp.setGoodsCount(1);
        cp.setGoodsImg(pro.getProductImg());
        redisTemplate.opsForList().leftPush(key,cp);




        /*WebShoppingcCart webShoppingcCart = new WebShoppingcCart();
        HttpSession session = request.getSession();
        Integer  userid= (Integer) session.getAttribute("user");
        UserBean user = (UserBean) redisTemplate.opsForValue().get("user");
        Integer biaoshi = 1;
        //*查询用户是否登录*//*

        if (user != null){
            Boolean aBoolean = redisTemplate.hasKey(user.getUserId());
            if (aBoolean) {
                webShoppingcCart = (WebShoppingcCart) redisTemplate.opsForValue().get(user.getUserId());
                for (chanpinBean emt : webShoppingcCart.getWebDrugBean()) {
                    Integer  id=emt.getProductId();
                    if (spid.equals(id)) {
                        emt.setAcount(emt.getAcount() + sl);
                        biaoshi=1;
                    }
                }
                if (biaoshi != 1) {
                    chanpinBean webDrugBean = cpServiceFeign.selectCar(spid);
                    webDrugBean.setAcount(sl);

                    webShoppingcCart.setAdddate(new Date().toString());
                    if (webShoppingcCart.getWebDrugBean()==null){
                        List<chanpinBean> objects = new ArrayList<>();
                        objects.add(webDrugBean);
                        webShoppingcCart.setWebDrugBean(objects);
                    }else{
                        webShoppingcCart.getWebDrugBean().add(webDrugBean);
                    }
                }
            } else {
                chanpinBean webDrugBean = cpServiceFeign.selectCar(spid);
                webDrugBean.setAcount(sl);
                webShoppingcCart.setAdddate(new Date().toString());
                if (webShoppingcCart.getWebDrugBean()==null){
                    List<chanpinBean> objects = new ArrayList<>();
                    objects.add(webDrugBean);
                    webShoppingcCart.setWebDrugBean(objects);
                }else{
                    webShoppingcCart.getWebDrugBean().add(webDrugBean);
                }
            }
            redisTemplate.opsForValue().set(user.getUserId(), webShoppingcCart, 20, TimeUnit.MINUTES);
            return "1";
        } else {
            return "0";
        }*/
    }

    @GetMapping("queryCart")
    @ResponseBody
    public List queryCart(){
        String key ="keys"+"70";
        //取redis
        List list = redisTemplate.opsForList().range(key,0, -1);
        System.out.println(list);
        return list;
    }

    /*查询购物车*/
    @RequestMapping("selectCarAll")
    @ResponseBody
    public List<WebShoppingcCart> selectCarAll(HttpServletRequest httpServletRequest){
        String key ="keys"+"70";
        List<WebShoppingcCart> list =redisTemplate.opsForList().range(key,0,-1);
        for (WebShoppingcCart ls:list) {
            String  a= ls.getGoodsName();
            System.out.println("============"+a);
        }
        return list;
        /*UserBean userBean = (UserBean) redisTemplate.opsForValue().get("user");
        WebShoppingcCart webShoppingcCart = new WebShoppingcCart();
        if (userBean!=null){
            webShoppingcCart = (WebShoppingcCart) redisTemplate.opsForValue().get(userBean.getUserId());
            return webShoppingcCart;
        }else{
            return  webShoppingcCart;
        }*/
    }




}
