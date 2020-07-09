package com.sirius.controller;

import com.sirius.entity.Account;
import com.sirius.entity.Restaurant;
import com.sirius.entity.User;
import com.sirius.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserHandler {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/findAllUser/{index}/{limit}")
    public List<User> findAllUser(@PathVariable("index") int index, @PathVariable("limit") int limit){
        return userRepository.findAllUser((index-1)*limit, limit);
    }

    @GetMapping("/findAllRestaurant/{index}/{limit}")
    public List<Restaurant> findAllRestaurant(@PathVariable("index") int index, @PathVariable("limit") int limit){
        return userRepository.findAllRestaurant((index-1)*limit, limit);
    }

    @GetMapping("/findByUid/{userid}")
    public List<User> findByUid(@PathVariable("userid") int userid){
        return userRepository.findByUid(userid);
    }

    @GetMapping("/count")
    public int count(){return userRepository.count();}


//    @GetMapping("/findByUid/{userid}")
//    public User findByUid(@PathVariable("userid") int userid){
//        return userRepository.findByUid(userid);
//    }

//    @GetMapping("/findByRid/{restaurantid}")
//    public List<Restaurant> findByRid(@PathVariable("restaurantid") int restaurantid){
//        return userRepository.findByRid(restaurantid);
//    }

    @PostMapping("/findByRname")
    public List<Restaurant> findByRname(@RequestBody Restaurant restaurant){
          return userRepository.findByRname(restaurant);
    }



    @PostMapping("/save")
    public void save(@RequestBody User user){
        userRepository.save(user);
    }

    @PutMapping("/updateByUid")
    public void updateByUid(@RequestBody User user){
        userRepository.updateByUid(user);
    }

    @PutMapping("/update")
    public void update(@RequestBody User user){
        User user1 = new User();
        user1.setUserid(user.getUserid());
        user1.setPassword(user.getPassword());
        user1.setUsername(user.getUsername());
        user1.setAddress(user.getAddress());
        user1.setTelephone(user.getTelephone());
        user1.setNickname(user.getNickname());
        userRepository.update(user);
    }



//    @PutMapping("/update")
//    public void update(@RequestBody User user){
//        User user1 = new User();
//        user1.setId(user.getId());
//        user1.setPassword(user.getPassword());
//        user1.setUsername(user.getUsername());
//        user1.setAddress(user.getAddress());
//        user1.setTelephone(user.getTelephone());
//        user1.setNickname(user.getNickname());
//        System.out.println(user);
//        System.out.println(user1);
//        userRepository.update(user);
//    }

    @PutMapping("/updateByRid")
    public void updateByRid(@RequestBody Restaurant restaurant){
        userRepository.updateByRid(restaurant);
    }

    @DeleteMapping("/deleteByName/{nickname}")
    public void deleteByName(@PathVariable("nickname") String nickname){
        userRepository.deleteByName(nickname);
    }

    @GetMapping("/deleteByUid/{userid}")
    public void deleteByUid(@PathVariable("userid") int userid){
        userRepository.deleteByUid(userid);
    }

//    @PutMapping("/deleteByUid/{userid}")
//    public void deleteByUid(@PathVariable("userid") int userid){
//        userRepository.deleteByUid(userid);
//    }

    @GetMapping("/deleteByRid/{restaurantid}")
    public void deleteByRid(@PathVariable("restaurantid") int restaurantid){
        userRepository.deleteByRid(restaurantid);
    }
}
