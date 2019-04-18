package com.jk.service;

import com.jk.model.Product;
import com.jk.model.Store;
import com.jk.model.Type;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient("server-provider")
public interface HomeServiceFeign extends HomeService{


}
