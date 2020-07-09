package com.sirius.entity;

import lombok.Data;

@Data
public class Menu {
    private int menuid;

    public int getMenuid() {
        return menuid;
    }

    public String getStorename() {
        return storename;
    }

    public float getPrice() {
        return price;
    }

    public int getStocks() {
        return stocks;
    }

    public String getDescription() {
        return description;
    }

    public String getMenutype() {
        return menutype;
    }

    public String getMenuname() {
        return menuname;
    }

    public String getPhoto() {
        return photo;
    }

    public String getMaterials() {
        return materials;
    }

    private String storename;

    public void setMenuid(int menuid) {
        this.menuid = menuid;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setStocks(int stocks) {
        this.stocks = stocks;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMenutype(String menutype) {
        this.menutype = menutype;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public float price;
    private int stocks;
    private String description;
    private String menutype;
    private String menuname;
    private String photo;
    private String materials;




}
