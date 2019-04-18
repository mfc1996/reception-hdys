package com.jk.service.impl;

import com.jk.mapper.HomeMapper;
import com.jk.model.Product;
import com.jk.model.Store;
import com.jk.model.Type;
import com.jk.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeMapper homeMapper;

    @Override
    @ResponseBody
    public List<Type> queryType() {
        Integer pid = 0;
        List<Type> list = nodeType(pid);
        return list;
    }

    @Override
    @ResponseBody
    public List<Product> queryProduct() {
        return homeMapper.queryProduct();
    }

    @Override
    @ResponseBody
    public Product queryProductById(Integer productId) {
        return homeMapper.queryProductById(productId);
    }

    @Override
    @ResponseBody
    public List<Store> queryStore() {
        return homeMapper.queryStore();
    }

    private List<Type> nodeType(Integer pid) {
        List<Type> list = homeMapper.queryType(pid);
        for (Type type: list ) {
            Integer id = type.getId();
            List<Type> nodes = nodeType(id);
            if(nodes.size()<=0){
                type.setSelectable(true);
            }else{
                type.setSelectable(false);
                type.setNodes(nodes);
            }
        }
        return list;
    }
}
