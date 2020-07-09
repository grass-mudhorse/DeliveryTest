package com.sirius.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    public long orderid;

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public String getStorename() {
        return storename;
    }

    public int restaurantid;
    public int userid;
    public String storename;

    public void setRestaurantid(int restaurantid) {
        this.restaurantid = restaurantid;
    }

    public void setUserid(int userid) {
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

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }

    public Date date;

    public long getOrderid() {
        return orderid;
    }

    public int getRestaurantid() {
        return restaurantid;
    }

    public int getUserid() {
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

    public float totalprice;
    public int state;
    public String note;
    public String address;
    public Date arrivingtime;
}
