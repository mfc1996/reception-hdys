package com.jk.model;


import java.io.Serializable;

/**
 * 用户表
 */
public class UserBean implements Serializable {

    private static final long serialVersionUID = 6516343751306319098L;
    private  Integer userId;
    private String userName;
    private Integer userSex;
    private Integer userAge;
    private Double userBalance;
    private String userDate;
    private String userImg;
    private String userAccount;
    private String userPassword;
    private String userPhone;
    private String userPhonePassword;
    private String userQQAccount;
    private String userQQPassword;
    private String userWeChatAccount;
    private String userWeChatPassword;
    private String roleName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Double getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(Double userBalance) {
        this.userBalance = userBalance;
    }

    public String getUserDate() {
        return userDate;
    }

    public void setUserDate(String userDate) {
        this.userDate = userDate;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPhonePassword() {
        return userPhonePassword;
    }

    public void setUserPhonePassword(String userPhonePassword) {
        this.userPhonePassword = userPhonePassword;
    }

    public String getUserQQAccount() {
        return userQQAccount;
    }

    public void setUserQQAccount(String userQQAccount) {
        this.userQQAccount = userQQAccount;
    }

    public String getUserQQPassword() {
        return userQQPassword;
    }

    public void setUserQQPassword(String userQQPassword) {
        this.userQQPassword = userQQPassword;
    }

    public String getUserWeChatAccount() {
        return userWeChatAccount;
    }

    public void setUserWeChatAccount(String userWeChatAccount) {
        this.userWeChatAccount = userWeChatAccount;
    }

    public String getUserWeChatPassword() {
        return userWeChatPassword;
    }

    public void setUserWeChatPassword(String userWeChatPassword) {
        this.userWeChatPassword = userWeChatPassword;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userSex=" + userSex +
                ", userAge=" + userAge +
                ", userBalance=" + userBalance +
                ", userDate='" + userDate + '\'' +
                ", userImg='" + userImg + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userPhonePassword='" + userPhonePassword + '\'' +
                ", userQQAccount='" + userQQAccount + '\'' +
                ", userQQPassword='" + userQQPassword + '\'' +
                ", userWeChatAccount='" + userWeChatAccount + '\'' +
                ", userWeChatPassword='" + userWeChatPassword + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
