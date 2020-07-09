package com.sirius.entity;

import lombok.Data;

@Data
public class Menu {
    private int menuid;
    private String storename;
    public float price;
    private int stocks;
    private String description;
    private String menutype;
    private String menuname;
    private String photo;
    private String materials;

//    public String getStoreName(){
//        return StoreName;
//    }
//    public String getDescription(){
//        return Description;
//    }
//    public String getMenuType(){
//        return MenuType;
//    }
//    public String getMenuName(){
//        return MenuName;
//    }
//    public String getPhoto(){
//        return Photo;
//    }
//    public String getMaterials(){
//        return Materials;
//    }
//    public int getStocks(){
//        return Stocks;
//    }
//    public float getPrice(){
//        return Price;
//    }


}
