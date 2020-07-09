package com.sirius.entity;

import lombok.Data;

@Data
public class OrderDetail {
    public long detailid;
    public long  orderid;
    public long menuid;
    public String menuname;
    public int menunumber;

    public void setDetailid(long detailid) {
        this.detailid = detailid;
    }

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }

    public void setMenuid(long menuid) {
        this.menuid = menuid;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public void setMenunumber(int menunumber) {
        this.menunumber = menunumber;
    }

    public long getDetailid() {
        return detailid;
    }

    public long getOrderid() {
        return orderid;
    }

    public long getMenuid() {
        return menuid;
    }

    public String getMenuname() {
        return menuname;
    }

    public int getMenunumber() {
        return menunumber;
    }
}
