package com.example.sysstudentloan.entity;

public class Authority {

    private Integer menuid;

    private String icon;

    private String menuname;

    private String hasThird;

    private String url;

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

    @Override
    public String toString() {
        return "Authority{" +
                "menuid=" + menuid +
                ", icon='" + icon + '\'' +
                ", menuname='" + menuname + '\'' +
                ", hasThird='" + hasThird + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}