package com.sirius.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Restaurant {
    private int restaurantid;
    private String username;
    private String password;

    public void setRestaurantid(int restaurantid) {
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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setPersontime(int persontime) {
        this.persontime = persontime;
    }

    private String storename;
    private String telephone;
    private String description;
    private int rating;

    public int getRestaurantid() {
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

    public String getDescription() {
        return description;
    }

    public int getRating() {
        return rating;
    }

    public int getPersontime() {
        return persontime;
    }

    private int persontime;

}
