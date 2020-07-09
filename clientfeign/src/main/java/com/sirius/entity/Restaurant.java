package com.sirius.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Restaurant extends Account{
    private long restaurantid;
    private String username;
    private String password;
    private String storename;
    private String telephone;
    private String address;
    private int rating;
    private String description;
    private int state;
    private long persontime;

    public void setRestaurantid(long restaurantid) {
        this.restaurantid = restaurantid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setPersontime(long persontime) {
        this.persontime = persontime;
    }

    public long getRestaurantid() {
        return restaurantid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getStorename() {
        return storename;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAddress() {
        return address;
    }

    public int getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public int getState() {
        return state;
    }

    public long getPersontime() {
        return persontime;
    }


}
