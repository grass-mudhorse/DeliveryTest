package com.sirius.feign;

import com.sirius.entity.Restaurant;
import com.sirius.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "user")
public interface UserFeign {
    @GetMapping("/user/findById/{userid}")
    public User findById(@PathVariable long userid);

    @PutMapping("/user/update")
    public void editProfile(@RequestBody User user);

    @GetMapping("/user/findAllUser/{index}/{limit}")
    public List<User> findAllUser(@PathVariable("index") int index, @PathVariable("limit") int limit);

    @GetMapping("/user/findAllRestaurant/{index}/{limit}")
    public List<Restaurant> findAllRestaurant(@PathVariable("index") int index, @PathVariable("limit") int limit);

    @GetMapping("/user/findByUid/{userid}")
    public List<User> findByUid(@PathVariable("userid") int userid);

    @GetMapping("/user/findByRid/{restaurantid}")
    public List<Restaurant> findByRid(@PathVariable("restaurantid") int restaurantid);


    @GetMapping("/user/findByName/{nickname}")
    public User findByName(@PathVariable("nickname") String nickname);

    @PostMapping("/user/save")
    public void save(@RequestBody User user);

    @PutMapping("/user/updateByUid")
    public void updateByUid(@RequestBody User user);

    @GetMapping("/user/count")
    public int count();

    @PostMapping("/user/findByRname")
    public List<Restaurant> findByRname(@RequestBody Restaurant restaurant);


    @PutMapping("/user/updateByRid")
    public void updateByRid(@RequestBody Restaurant restaurant);

    @DeleteMapping("/user/deleteByName/{nickname}")
    public void deleteByName(@PathVariable("nickname") String nickname);

    @GetMapping("/user/deleteByUid/{userid}")
    public void deleteByUid(@PathVariable("userid") int userid);

//    @PutMapping("/user/deleteByUid/{userid}")
//    public void deleteByUid(@PathVariable("userid") int userid);

    @GetMapping("/user/deleteByRid/{restaurantid}")
    public void deleteByRid(@PathVariable("restaurantid") int restaurantid);
}
