package com.jk.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

//收藏表
@Document(collection = "collect")
public class Collect implements Serializable {

    private static final long serialVersionUID = -4301684438677315180L;
    @Id
    private String id;
    private Integer productId;
    private Integer userId;

    @Transient
    private String productName;
    @Transient
    private String productImg;
    @Transient
    private Double productPrice;

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "id='" + id + '\'' +
                ", productId=" + productId +
                ", userId=" + userId +
                ", productName='" + productName + '\'' +
                ", productImg='" + productImg + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}
