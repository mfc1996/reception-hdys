package com.jk.mapper;

import com.jk.model.Product;
import com.jk.model.Store;
import com.jk.model.Type;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface HomeMapper {

    List<Type> queryType(Integer pid);

    List<Product> queryProduct();

    Product queryProductById(Integer productId);

    List<Store> queryStore();
}
