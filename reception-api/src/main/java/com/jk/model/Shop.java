package com.jk.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 购物车
 */
@Document(collection = "shop")
public class Shop implements Serializable {

    private static final long serialVersionUID = 8601237752943030363L;
    @Id
    private String id;
    private Integer productId;
    private String productName;
    private Integer count;
    private Double productPrice;
    private String productImg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id='" + id + '\'' +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", count=" + count +
                ", productPrice=" + productPrice +
                ", productImg='" + productImg + '\'' +
                '}';
    }
}
