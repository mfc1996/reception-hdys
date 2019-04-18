package com.jk.service;


import org.springframework.cloud.openfeign.FeignClient;



@FeignClient("server-provider")
public interface SeckillServiceFeign extends SeckillService{



}
