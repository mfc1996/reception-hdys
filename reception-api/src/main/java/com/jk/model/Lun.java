package com.jk.model;

import java.io.Serializable;

/**
 * 轮播图
 */
public class Lun implements Serializable {

    private static final long serialVersionUID = -414655520029763507L;
    private Integer id;
    private String lunImg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLunImg() {
        return lunImg;
    }

    public void setLunImg(String lunImg) {
        this.lunImg = lunImg;
    }

    @Override
    public String toString() {
        return "Lun{" +
                "id=" + id +
                ", lunImg='" + lunImg + '\'' +
                '}';
    }
}
