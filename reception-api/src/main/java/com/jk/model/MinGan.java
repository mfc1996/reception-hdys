package com.jk.model;

import java.io.Serializable;

/**
 * 敏感词
 */
public class MinGan implements Serializable {
    private static final long serialVersionUID = 4768856346703628425L;
    private Integer id;
    private String mgname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMgname() {
        return mgname;
    }

    public void setMgname(String mgname) {
        this.mgname = mgname;
    }

    @Override
    public String toString() {
        return "Mingan{" +
                "id=" + id +
                ", mgname='" + mgname + '\'' +
                '}';
    }
}