/**
 * Copyright (C),2019, 金科教育
 * FileName: Comment
 * Author:   马法冲
 * Date:     2019/4/25 18:33
 * Description: a
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈a〉
 *
 * @author MC
 * @create 2019/4/25
 * @since 1.0.0
 */
public class Comment implements Serializable {

    private static final long serialVersionUID = -6123098556575561412L;

    private Integer id;
    private String commentInfo;
    private Integer orderId;
    private Integer userId;
    private Integer status;
    private Date commentTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommentInfo() {
        return commentInfo;
    }

    public void setCommentInfo(String commentInfo) {
        this.commentInfo = commentInfo;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", commentInfo='" + commentInfo + '\'' +
                ", orderId=" + orderId +
                ", userId=" + userId +
                ", status=" + status +
                ", commentTime='" + commentTime + '\'' +
                '}';
    }
}