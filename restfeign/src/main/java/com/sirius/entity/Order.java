package com.sirius.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    public int orderid;
    public int restaurantid;
    public int userid;
    public Date date;
    public float totalprice;
    public String state;
    public String note;
    public String address;
    public Date arrivingtime;
}