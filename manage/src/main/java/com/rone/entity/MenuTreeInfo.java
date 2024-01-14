package com.rone.entity;

import java.util.List;

/**
 * 菜单树实体
 *
 * @author rone
 */
public class MenuTreeInfo {

    private Integer id;

    private String title;

    private List<MenuTreeInfo> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MenuTreeInfo> getChildren() {
        return children;
    }

    public void setChildren(List<MenuTreeInfo> children) {
        this.children = children;
    }
}
