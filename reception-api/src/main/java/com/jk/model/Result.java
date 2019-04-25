package com.jk.model;

import java.io.Serializable;
import java.util.List;

public class Result implements Serializable {

    private static final long serialVersionUID = 3880055491696875309L;
    private List<Product> productList;

    private Long recordCount;

    private int pageCount;

    private int curPage;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Long getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Long recordCount) {
        this.recordCount = recordCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    @Override
    public String toString() {
        return "Result{" +
                "productList=" + productList +
                ", recordCount=" + recordCount +
                ", pageCount=" + pageCount +
                ", curPage=" + curPage +
                '}';
    }
}
