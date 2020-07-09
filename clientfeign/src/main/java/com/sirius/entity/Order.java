package com.sirius.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    public long orderid;
    public String storename;
    public long restaurantid;

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public long userid;
    public Date date;
    public float totalprice;
    public int state;
    public String note;
    public String address;
    public Date arrivingtime;

    public long getOrderid() {
        return orderid;
    }

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }

    public void setRestaurantid(long restaurantid) {
        this.restaurantid = restaurantid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTotalprice(float totalprice) {
        this.totalprice = totalprice;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setArrivingtime(Date arrivingtime) {
        this.arrivingtime = arrivingtime;
    }

    public long getRestaurantid() {
        return restaurantid;
    }

    public long getUserid() {
        return userid;
    }

    public Date getDate() {
        return date;
    }

    public float getTotalprice() {
        return totalprice;
    }

    public int getState() {
        return state;
    }

    public String getNote() {
        return note;
    }

    public String getAddress() {
        return address;
    }

    public Date getArrivingtime() {
        return arrivingtime;
    }


}
