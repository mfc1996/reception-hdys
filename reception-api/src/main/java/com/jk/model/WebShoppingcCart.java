package com.jk.model;

import java.io.Serializable;
import java.util.List;

public class WebShoppingcCart implements Serializable {

    private static final long serialVersionUID = 5557513998008525439L;
    private Integer cartid;//购物车id

    private String adddate;//加入购物车时间

    private List<chanpinBean> webDrugBean;

    public Integer getCartid() {
        return cartid;
    }

    public void setCartid(Integer cartid) {
        this.cartid = cartid;
    }


    public String getAdddate() {
        return adddate;
    }

    public void setAdddate(String adddate) {
        this.adddate = adddate;
    }

    public List<chanpinBean> getWebDrugBean() {
        return webDrugBean;
    }

    public void setWebDrugBean(List<chanpinBean> webDrugBean) {
        this.webDrugBean = webDrugBean;
    }
}
