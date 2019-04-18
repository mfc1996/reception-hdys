package com.jk.model;

import java.io.Serializable;

public class SpikeBean implements Serializable {
    private static final long serialVersionUID = 8512496632276516373L;

    private  Integer id;
    private  String name;
    private  Integer productId;
    private String spikeInfo;
    private Double seckillPrice;
    private String img;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getSpikeInfo() {
        return spikeInfo;
    }

    public void setSpikeInfo(String spikeInfo) {
        this.spikeInfo = spikeInfo;
    }

    public double getSeckillPrice() {
        return seckillPrice;
    }

    public void setSeckillPrice(double seckillPrice) {
        this.seckillPrice = seckillPrice;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "SpikeBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productId=" + productId +
                ", spikeInfo='" + spikeInfo + '\'' +
                ", seckillPrice=" + seckillPrice +
                ", img='" + img + '\'' +
                '}';
    }
}
