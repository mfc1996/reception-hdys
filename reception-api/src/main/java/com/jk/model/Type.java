/**
 * Copyright (C),2019, 金科教育
 * FileName: Tree
 * Author:   马法冲
 * Date:     2019/4/16 21:28
 * Description: a
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.model;

import sun.reflect.generics.tree.Tree;

import java.io.Serializable;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈a〉
 *类型
 * @author MC
 * @create 2019/4/16
 * @since 1.0.0
 */
public class Type implements Serializable {

    private static final long serialVersionUID = -4060313072045063157L;

    private Integer id;
    private String text;
    private String href;
    private Integer pid;
    private Boolean selectable;
    private List<Type> nodes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Boolean getSelectable() {
        return selectable;
    }

    public void setSelectable(Boolean selectable) {
        this.selectable = selectable;
    }

    public List<Type> getNodes() {
        return nodes;
    }

    public void setNodes(List<Type> nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", href='" + href + '\'' +
                ", pid=" + pid +
                ", selectable=" + selectable +
                ", nodes=" + nodes +
                '}';
    }
}