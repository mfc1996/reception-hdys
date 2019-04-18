package com.jk.controller;

import com.alibaba.fastjson.JSONObject;
import com.jk.model.Product;
import com.jk.model.Store;
import com.jk.model.Type;
import com.jk.service.HomeServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    public HomeServiceFeign homeServiceFeign;

    /**
     * 查询悬浮菜单
     * @return
     */
    @GetMapping("queryType")
    public List<Type> queryType(){
        return homeServiceFeign.queryType();
    }

    /**
     * 查询商品
     * @return
     */
    @GetMapping("queryProduct")
    public List<Product> queryProduct(){
        return homeServiceFeign.queryProduct();
    }

    /**
     * 回显商品
     * @param productId
     * @return
     */
    @GetMapping("queryProductById/{productId}")
    public Product queryProductById(@PathVariable("productId") Integer productId){
        return homeServiceFeign.queryProductById(productId);
    }

    /**
     * 店铺查询
     */
    @GetMapping("queryStore")
    public List<Store> queryStore(){
        List<Store> stores = homeServiceFeign.queryStore();
        return stores;
    }
}
