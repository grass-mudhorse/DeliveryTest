package com.sirius.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Review {
    private long reviewid;
    private long orderid;
    private long restaurantid;
    private String nickname;

    public void setReviewid(long reviewid) {
        this.reviewid = reviewid;
    }

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }

    public void setRestaurantid(long restaurantid) {
        this.restaurantid = restaurantid;
    }

    public long getReviewid() {
        return reviewid;
    }

    public long getOrderid() {
        return orderid;
    }

    public long getRestaurantid() {
        return restaurantid;
    }

    public String getNickname() {
        return nickname;
    }

    public Date getDate() {
        return date;
    }

    public int getRating() {
        return rating;
    }

    public String getContent() {
        return content;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private Date date;
    private int rating;
    private String content;
}
