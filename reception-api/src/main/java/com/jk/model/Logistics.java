package com.jk.model;

import java.io.Serializable;

public class Logistics implements Serializable {

    private static final long serialVersionUID = 339823049170793805L;
    private Integer logisticsId;
    private String logisticsName;

    public Integer getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(Integer logisticsId) {
        this.logisticsId = logisticsId;
    }

    public String getLogisticsName() {
        return logisticsName;
    }

    public void setLogisticsName(String logisticsName) {
        this.logisticsName = logisticsName;
    }

    @Override
    public String toString() {
        return "Logistics{" +
                "logisticsId=" + logisticsId +
                ", logisticsName='" + logisticsName + '\'' +
                '}';
    }
}
