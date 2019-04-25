package com.jk.model;

import java.io.Serializable;

/**
 * 店铺
 */
public class Store implements Serializable {

    private static final long serialVersionUID = -2924924642485769307L;
    private Integer storeId;
    private String storeName;
    private String  storeImg;

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreImg() {
        return storeImg;
    }

    public void setStoreImg(String storeImg) {
        this.storeImg = storeImg;
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeId=" + storeId +
                ", storeName='" + storeName + '\'' +
                ", storeImg='" + storeImg + '\'' +
                '}';
    }
}
