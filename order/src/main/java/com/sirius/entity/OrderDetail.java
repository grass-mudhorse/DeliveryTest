package com.sirius.entity;

import lombok.Data;

@Data
public class OrderDetail {
    public int detailid;
    public int  orderid;
    public int menuid;

    public void setDetailid(int detailid) {
        this.detailid = detailid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public void setMenuid(int menuid) {
        this.menuid = menuid;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public void setMenunumber(int menunumber) {
        this.menunumber = menunumber;
    }

    public int getDetailid() {
        return detailid;
    }

    public int getOrderid() {
        return orderid;
    }

    public int getMenuid() {
        return menuid;
    }

    public String getMenuname() {
        return menuname;
    }

    public int getMenunumber() {
        return menunumber;
    }

    public String menuname;
    public int menunumber;
}
