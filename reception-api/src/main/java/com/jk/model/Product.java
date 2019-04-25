package com.jk.model;

import java.io.Serializable;

/**
 * 产品
 */
public class Product implements Serializable {
    private static final long serialVersionUID = -8419100528968762962L;

    private Integer productId;
    private String productName;
    private Double productPrice;
    private Integer productDiscountId;
    private Integer productCollectionId;
    private Integer typeId;
    private String typeName;
    private String productColor;
    private Integer productStockId;
    private String productStockName;
    private String productSize;
    private String productDeliveryTime;
    private Integer productCommentId;
    private Integer productTransactionId;
    private String paymentId;
    private Integer productState;
    private String addressId;
    private Integer proDealCount;
    private String productImg;

    public String getProductStockName() {
        return productStockName;
    }

    public void setProductStockName(String productStockName) {
        this.productStockName = productStockName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

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

    public Double getProductPrice() {
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

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productDiscountId=" + productDiscountId +
                ", productCollectionId=" + productCollectionId +
                ", typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", productColor='" + productColor + '\'' +
                ", productStockId=" + productStockId +
                ", productStockName='" + productStockName + '\'' +
                ", productSize='" + productSize + '\'' +
                ", productDeliveryTime='" + productDeliveryTime + '\'' +
                ", productCommentId=" + productCommentId +
                ", productTransactionId=" + productTransactionId +
                ", paymentId='" + paymentId + '\'' +
                ", productState=" + productState +
                ", addressId='" + addressId + '\'' +
                ", proDealCount=" + proDealCount +
                ", productImg='" + productImg + '\'' +
                '}';
    }
}
