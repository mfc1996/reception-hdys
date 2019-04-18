package com.jk.model;

import java.io.Serializable;

public class Discount implements Serializable {

    private static final long serialVersionUID = -8318327778051514044L;
    private Integer discountId;
    private String discountName;
    private String discountImg;
    private String discountInfo;

    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public String getDiscountImg() {
        return discountImg;
    }

    public void setDiscountImg(String discountImg) {
        this.discountImg = discountImg;
    }

    public String getDiscountInfo() {
        return discountInfo;
    }

    public void setDiscountInfo(String discountInfo) {
        this.discountInfo = discountInfo;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "discountId=" + discountId +
                ", discountName='" + discountName + '\'' +
                ", discountImg='" + discountImg + '\'' +
                ", discountInfo='" + discountInfo + '\'' +
                '}';
    }
}
