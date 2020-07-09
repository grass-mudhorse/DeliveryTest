package com.sirius.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Review {
    private long reviewid;
    private long orderid;
    private long restaurantid;
    private Date date;
    private int rating;
    private String content;
    private String nickname;
}
