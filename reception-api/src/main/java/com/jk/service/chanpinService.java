package com.jk.service;

import com.jk.model.chanpinBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

public interface chanpinService {



    @GetMapping("querychanpinList")
    @ResponseBody
    HashMap<String, Object> querychanpinList(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows);
    @GetMapping("queryProduct")
    @ResponseBody
    List<chanpinBean> queryProduct();

    @GetMapping("selectCar")
    @ResponseBody
    chanpinBean selectCar(@RequestParam("spid")Integer spid);
}
