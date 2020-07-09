package com.sirius.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Restaurant extends Account {
    private int restaurantid;
    private String username;
    private String password;
    private String storename;
    private String telephone;
    private String description;
    private int rating;
    private int persontime;
    private int state;

}
