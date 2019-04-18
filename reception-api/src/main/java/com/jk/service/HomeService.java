package com.jk.service;

import com.jk.model.Product;
import com.jk.model.Store;
import com.jk.model.Type;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface HomeService {

    @GetMapping("queryType")
    @ResponseBody
    List<Type> queryType();

    @GetMapping("queryProduct")
    @ResponseBody
    List<Product> queryProduct();

    @GetMapping("queryProductById/{productId}")
    @ResponseBody
    Product queryProductById(@PathVariable("productId") Integer productId);

    @GetMapping("queryStore")
    @ResponseBody
    List<Store> queryStore();
}
