package com.jk.model;

import java.io.Serializable;

public class ProductType implements Serializable {

    private static final long serialVersionUID = 3072305696460628076L;
    private Integer productTypeId;
    private Integer productId;
    private Integer typeId;

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "productTypeId=" + productTypeId +
                ", productId=" + productId +
                ", typeId=" + typeId +
                '}';
    }
}
