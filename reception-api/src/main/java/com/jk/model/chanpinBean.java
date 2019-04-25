/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: chanpinBean
 * Author:   郭晨凯
 * Date:     2019-04-17 14:55
 * Description: 郭晨凯产品列表
 * History:
 * 郭晨凯        <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.model;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈郭晨凯产品列表〉
 *
 * @author chenkai
 * @create 2019-04-17
 * @since 1.0.0
 */

public class chanpinBean implements Serializable {
    private static final long serialVersionUID = 606418059593846595L;

    private Integer    productId;
    private  String productName;
    private   Double   productPrice;
    private  Integer      productDiscountId;
    private  Integer      productCollectionId;
    private  Integer       typeId;
    private   String     productColor;
    private   Integer      productStockId;
    private    String       productSize;
    private     String     productDeliveryTime;
    private    Integer       productCommentId;
    private    Integer       productTransactionId;
    private     String     paymentId;
    private     Integer    productState;
    private      String    addressId;
    private    Integer     proDealCount;

    private String  img;

    public String getImg(String s) {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    private Integer acount;//数量

    public Integer getAcount() {
        return acount;
    }

    public void setAcount(Integer acount) {
        this.acount = acount;
    }

    private  String productImg;

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice(int i) {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductDiscountId() {
        return productDiscountId;
    }

    public void setProductDiscountId(Integer productDiscountId) {
        this.productDiscountId = productDiscountId;
    }

    public Integer getProductCollectionId() {
        return productCollectionId;
    }

    public void setProductCollectionId(Integer productCollectionId) {
        this.productCollectionId = productCollectionId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public Integer getProductStockId() {
        return productStockId;
    }

    public void setProductStockId(Integer productStockId) {
        this.productStockId = productStockId;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getProductDeliveryTime() {
        return productDeliveryTime;
    }

    public void setProductDeliveryTime(String productDeliveryTime) {
        this.productDeliveryTime = productDeliveryTime;
    }

    public Integer getProductCommentId() {
        return productCommentId;
    }

    public void setProductCommentId(Integer productCommentId) {
        this.productCommentId = productCommentId;
    }

    public Integer getProductTransactionId() {
        return productTransactionId;
    }

    public void setProductTransactionId(Integer productTransactionId) {
        this.productTransactionId = productTransactionId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getProductState() {
        return productState;
    }

    public void setProductState(Integer productState) {
        this.productState = productState;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public Integer getProDealCount() {
        return proDealCount;
    }

    public void setProDealCount(Integer proDealCount) {
        this.proDealCount = proDealCount;
    }
}
