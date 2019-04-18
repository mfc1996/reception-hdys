package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(value = "SERVER-PROVIDER")
public interface chanpinServiceFeign extends  chanpinService {

}
