/**
 * Copyright (C),2019, 金科教育
 * FileName: User
 * Author:   马法冲
 * Date:     2019/4/16 20:11
 * Description: a
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.model;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈a〉
 *
 * @author MC
 * @create 2019/4/16
 * @since 1.0.0
 */
public class User implements Serializable{

 private static final long serialVersionUID = 8714977646563096221L;

 private Integer userId;
 private String userName;
 private Integer userSex;
 private Integer userAge;
 private String userBalance;
 private String userDate;
 private String roleId;
 private String userImg;
 private String userAccount;
 private String userPassword;
 private String userPhone;
 private String userPhonePassword;
 private String userQQAccount;
 private String userQQPassword;
 private String userWeChatAccount;
 private String userWeChatPassword;

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

 public String getUserBalance() {
  return userBalance;
 }

 public void setUserBalance(String userBalance) {
  this.userBalance = userBalance;
 }

 public String getUserDate() {
  return userDate;
 }

 public void setUserDate(String userDate) {
  this.userDate = userDate;
 }

 public String getRoleId() {
  return roleId;
 }

 public void setRoleId(String roleId) {
  this.roleId = roleId;
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

 @Override
 public String toString() {
  return "User{" +
          "userId=" + userId +
          ", userName='" + userName + '\'' +
          ", userSex=" + userSex +
          ", userAge=" + userAge +
          ", userBalance='" + userBalance + '\'' +
          ", userDate='" + userDate + '\'' +
          ", roleId='" + roleId + '\'' +
          ", userImg='" + userImg + '\'' +
          ", userAccount='" + userAccount + '\'' +
          ", userPassword='" + userPassword + '\'' +
          ", userPhone='" + userPhone + '\'' +
          ", userPhonePassword='" + userPhonePassword + '\'' +
          ", userQQAccount='" + userQQAccount + '\'' +
          ", userQQPassword='" + userQQPassword + '\'' +
          ", userWeChatAccount='" + userWeChatAccount + '\'' +
          ", userWeChatPassword='" + userWeChatPassword + '\'' +
          '}';
 }
}