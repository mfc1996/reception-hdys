package com.jk.model;

import java.io.Serializable;

/**
 * 库存
 */
public class Stock implements Serializable {

    private static final long serialVersionUID = 1484523074867651845L;
    private Integer stockId;
    private String stockName;

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockId=" + stockId +
                ", stockName='" + stockName + '\'' +
                '}';
    }
}
