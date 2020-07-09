package com.sirius.controller;

import com.sirius.entity.Restaurant;
import com.sirius.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RequestMapping("/admin/restaurantpage")
@RestController
public class RestHandler {
    @Autowired
    private UserFeign userFeign;
    @CrossOrigin(allowCredentials = "true",allowedHeaders = "*",methods = {RequestMethod.GET,
    RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.PUT,
    RequestMethod.PATCH}, origins="*")
    @GetMapping("/findAllRestaurant/{index}/{limit}")
    public List<Restaurant> findAllRestaurant(@PathVariable("index") int index, @PathVariable("limit") int limit){
        return userFeign.findAllRestaurant(index, limit);
    }


    @CrossOrigin(allowCredentials = "true",allowedHeaders = "*",methods = {RequestMethod.GET,
    RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.PUT,
    RequestMethod.PATCH}, origins="*")
    @PostMapping("/findByRname")
    public List<Restaurant> findByRname(@RequestBody Restaurant restaurant){
        return userFeign.findByRname(restaurant);
    }



    @CrossOrigin(allowCredentials = "true",allowedHeaders = "*",methods = {RequestMethod.GET,
    RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.PUT,
    RequestMethod.PATCH}, origins="*")
    @PutMapping("/updateByRid")
    public void updateByRid(@RequestBody Restaurant restaurant)throws NoSuchAlgorithmException{
        restaurant.setPassword(hashPassword(restaurant.getPassword()));
        userFeign.updateByRid(restaurant);
    }

    public String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(password.getBytes());
        BigInteger bigInt = new BigInteger(1,messageDigest);
        String hashpassword = bigInt.toString(16);
        while(hashpassword.length() < 32){
            hashpassword = "0" + hashpassword;
        }
        return hashpassword;
    }



    @CrossOrigin(allowCredentials = "true",allowedHeaders = "*",methods = {RequestMethod.GET,
    RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.PUT,
    RequestMethod.PATCH}, origins="*")
    @GetMapping("/deleteByRid/{restaurantid}")
    public void deleteByRid(@PathVariable("restaurantid") int restaurantid){
        userFeign.deleteByRid(restaurantid);
    }

}
