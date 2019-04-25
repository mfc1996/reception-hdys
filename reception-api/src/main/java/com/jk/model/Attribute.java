package com.jk.model;

import java.io.Serializable;

/**
 * 属性表
 */
public class Attribute implements Serializable {
    private static final long serialVersionUID = 5264138957300284207L;
    private Integer attributeId;
    private String attributeBrand;
    private String attributeFabric;
    private String attributeCommute;
    private String attributeTime;
    private String attributeThickness;
    private String attributeAgeOfApplication;
    private String attributePattern;
    private String attributeCombinationForm;
    private String attributeClothingLength;
    private String attributeSize;
    private String attributeStyle;
    private String attributeColorClassification	;
    private String attributeComponentContent;
    private String attributeDesign;
    private String attributeClothingVersion	;
    private Integer typeId;
    private String typeName;
    private Integer productId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Integer attributeId) {
        this.attributeId = attributeId;
    }

    public String getAttributeBrand() {
        return attributeBrand;
    }

    public void setAttributeBrand(String attributeBrand) {
        this.attributeBrand = attributeBrand;
    }

    public String getAttributeFabric() {
        return attributeFabric;
    }

    public void setAttributeFabric(String attributeFabric) {
        this.attributeFabric = attributeFabric;
    }

    public String getAttributeCommute() {
        return attributeCommute;
    }

    public void setAttributeCommute(String attributeCommute) {
        this.attributeCommute = attributeCommute;
    }

    public String getAttributeTime() {
        return attributeTime;
    }

    public void setAttributeTime(String attributeTime) {
        this.attributeTime = attributeTime;
    }

    public String getAttributeThickness() {
        return attributeThickness;
    }

    public void setAttributeThickness(String attributeThickness) {
        this.attributeThickness = attributeThickness;
    }

    public String getAttributeAgeOfApplication() {
        return attributeAgeOfApplication;
    }

    public void setAttributeAgeOfApplication(String attributeAgeOfApplication) {
        this.attributeAgeOfApplication = attributeAgeOfApplication;
    }

    public String getAttributePattern() {
        return attributePattern;
    }

    public void setAttributePattern(String attributePattern) {
        this.attributePattern = attributePattern;
    }

    public String getAttributeCombinationForm() {
        return attributeCombinationForm;
    }

    public void setAttributeCombinationForm(String attributeCombinationForm) {
        this.attributeCombinationForm = attributeCombinationForm;
    }

    public String getAttributeClothingLength() {
        return attributeClothingLength;
    }

    public void setAttributeClothingLength(String attributeClothingLength) {
        this.attributeClothingLength = attributeClothingLength;
    }

    public String getAttributeSize() {
        return attributeSize;
    }

    public void setAttributeSize(String attributeSize) {
        this.attributeSize = attributeSize;
    }

    public String getAttributeStyle() {
        return attributeStyle;
    }

    public void setAttributeStyle(String attributeStyle) {
        this.attributeStyle = attributeStyle;
    }

    public String getAttributeColorClassification() {
        return attributeColorClassification;
    }

    public void setAttributeColorClassification(String attributeColorClassification) {
        this.attributeColorClassification = attributeColorClassification;
    }

    public String getAttributeComponentContent() {
        return attributeComponentContent;
    }

    public void setAttributeComponentContent(String attributeComponentContent) {
        this.attributeComponentContent = attributeComponentContent;
    }

    public String getAttributeDesign() {
        return attributeDesign;
    }

    public void setAttributeDesign(String attributeDesign) {
        this.attributeDesign = attributeDesign;
    }

    public String getAttributeClothingVersion() {
        return attributeClothingVersion;
    }

    public void setAttributeClothingVersion(String attributeClothingVersion) {
        this.attributeClothingVersion = attributeClothingVersion;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "attributeId=" + attributeId +
                ", attributeBrand='" + attributeBrand + '\'' +
                ", attributeFabric='" + attributeFabric + '\'' +
                ", attributeCommute='" + attributeCommute + '\'' +
                ", attributeTime='" + attributeTime + '\'' +
                ", attributeThickness='" + attributeThickness + '\'' +
                ", attributeAgeOfApplication='" + attributeAgeOfApplication + '\'' +
                ", attributePattern='" + attributePattern + '\'' +
                ", attributeCombinationForm='" + attributeCombinationForm + '\'' +
                ", attributeClothingLength='" + attributeClothingLength + '\'' +
                ", attributeSize='" + attributeSize + '\'' +
                ", attributeStyle='" + attributeStyle + '\'' +
                ", attributeColorClassification='" + attributeColorClassification + '\'' +
                ", attributeComponentContent='" + attributeComponentContent + '\'' +
                ", attributeDesign='" + attributeDesign + '\'' +
                ", attributeClothingVersion='" + attributeClothingVersion + '\'' +
                ", typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", productId=" + productId +
                '}';
    }
}
