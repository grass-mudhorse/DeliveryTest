package com.sirius.repository;

import com.sirius.entity.Restaurant;

import java.util.List;

public interface RestRepository {
    public Restaurant login(String username, String password);
    public List<Restaurant> findAllRestaurant();
    public Restaurant findByRname(String rname);
}
