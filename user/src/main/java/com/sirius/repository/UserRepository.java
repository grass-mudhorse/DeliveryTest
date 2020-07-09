package com.sirius.repository;


import com.sirius.entity.Restaurant;
import com.sirius.entity.User;

import java.util.List;

public interface UserRepository {
    public List<User> findAllUser(int index, int limit);
    public List<Restaurant> findAllRestaurant(int index, int limit);
    public List<User> findByUid(int userid);
    public List<Restaurant> findByRname(Restaurant restaurant);

    public int count();
    public void save(User user);
    public void updateByUid(User user);
    public void deleteByUid(int userid);
    public void deleteByRid(int restaurantid);
    public void deleteByName(String nickname);
    public void updateByRid(Restaurant restaurant);
    public void update(User user);
}
