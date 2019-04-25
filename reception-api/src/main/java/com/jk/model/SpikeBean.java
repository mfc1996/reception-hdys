package com.jk.model;

import java.io.Serializable;
import java.util.Date;

public class SpikeBean implements Serializable {
    private static final long serialVersionUID = 8512496632276516373L;

    private  Integer id;
    private  String name;
    private  Integer productId;
    private String spikeInfo;
    private Double seckillPrice;
    private String img;
    private Integer productStock;


    private Date startDate;

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

    public Double getSeckillPrice() {
        return seckillPrice;
    }

    public void setSeckillPrice(Double seckillPrice) {
        this.seckillPrice = seckillPrice;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
