/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: chanserviceImpl
 * Author:   郭晨凯
 * Date:     2019-04-17 15:28
 * Description: 产品业务类
 * History:
 * 郭晨凯        <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service;

import com.jk.mapper.chanpinMapper;
import com.jk.model.chanpinBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈产品业务类〉
 *
 * @author chenkai
 * @create 2019-04-17
 * @since 1.0.0
 */

@Controller
public class chanserviceImpl implements chanpinService{

    @Autowired
    private chanpinMapper cpMapper;

    @Override
    @ResponseBody
    public HashMap<String, Object> querychanpinList(Integer page,Integer rows) {

        HashMap<String,Object> hashMap = new HashMap<>();
        //查询总条数
        Integer count =cpMapper.queryChanpinCount();

        //分页
        Integer start =(page-1)*rows;
        List<chanpinBean> list =cpMapper.queryChanpinList(start,rows);
        hashMap.put("total",count);
        hashMap.put("rows",list);
        return hashMap;
    }

    @Override
    @ResponseBody
    public List<chanpinBean> queryProduct() {
        return cpMapper.queryProduct();
    }

    @Override
    @ResponseBody
    public chanpinBean selectCar(@RequestParam("spid") Integer spid) {
        chanpinBean cpBean = cpMapper.selectCar(spid);
        return cpBean;
    }
}
