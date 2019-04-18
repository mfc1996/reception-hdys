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

import com.jk.model.chanpinBean;
import com.jk.service.chanpinServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈gck〉
 *
 * @author chenkai
 * @create 2019-04-17
 * @since 1.0.0
 */
@Controller
public class chanpinController {

    @Autowired
    private chanpinServiceFeign cpServiceFeign;

    @GetMapping("queryProList")
    @ResponseBody
    public HashMap<String,Object> querychanpinList(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows){
        HashMap<String,Object> hash= cpServiceFeign.querychanpinList(page,rows);

        return hash;
    }

    /**
     * 查询商品
     * @return
     */
    @GetMapping("queryProduct")
    @ResponseBody
    public List<chanpinBean> queryProduct(){
        return cpServiceFeign.queryProduct();
    }

}