package com.example.sysstudentloan.entity;

import java.util.List;

public class ParentAuthority {

    private Integer menuid;

    private String icon;

    private String menuname;

    private String hasThird;

    private String url;

    private List<Authority> menus;

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getHasThird() {
        return hasThird;
    }

    public void setHasThird(String hasThird) {
        this.hasThird = hasThird;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Authority> getMenus() {
        return menus;
    }

    public void setMenus(List<Authority> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "ParentAuthority{" +
                "menuid=" + menuid +
                ", icon='" + icon + '\'' +
                ", menuname='" + menuname + '\'' +
                ", hasThird='" + hasThird + '\'' +
                ", url='" + url + '\'' +
                ", authorities=" + menus +
                '}';
    }
}
