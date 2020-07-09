package com.sirius.entity;

import lombok.Data;

@Data
public class OrderDetail {
    public int detailid;
    public int  orderid;
    public int menuid;
    public String menuname;
    public int menunumber;
}
