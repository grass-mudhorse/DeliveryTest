package com.sirius.controller;


import com.sirius.entity.Account;
import com.sirius.entity.Restaurant;
import com.sirius.feign.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@CrossOrigin
@RequestMapping("/restaurant/account")
@RestController
public class AccountHandler {
    @Value("${server.port}")
    private String port;

    @Autowired
    private AccountFeign accountFeign;

    @GetMapping("/index")
    public String index(){
        return this.port;
    }

    @CrossOrigin(allowCredentials="true", allowedHeaders="*", methods={RequestMethod.GET,
            RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS,
            RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.PATCH}, origins="*")
    @GetMapping("/login/{username}/{password}")
    public Map<String,Object> login(@PathVariable String username,@PathVariable String password, HttpSession session) throws NoSuchAlgorithmException {
        Map<String,Object> hashmap = new HashMap<String,Object>();
        System.out.println("Accepted Request");
        String hashpassword = hashPassword(password);
        Object obj = accountFeign.login(username,hashpassword,"restaurant");
        System.out.println(hashpassword);
        if(obj == null) {
            //Log in failed
            hashmap.put("token","0");
            return hashmap;
        }
        else {
            //Log in successfully
            Restaurant restaurant = convertRest((LinkedHashMap<String, Object>) obj);
            hashmap.put("token","1");
            hashmap.put("restaurant",restaurant);
            return hashmap;
        }
    }

    public Restaurant convertRest(LinkedHashMap<String,Object> hashMap){
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantid(((Integer)hashMap.get("restaurantid")).longValue());
        restaurant.setUsername((String)hashMap.get("username"));
        restaurant.setStorename((String)hashMap.get("storename"));
        restaurant.setPassword((String)hashMap.get("password"));
        restaurant.setAddress((String)hashMap.get("address"));
        restaurant.setDescription((String)hashMap.get("description"));
        restaurant.setRating((int)hashMap.get("rating"));
        restaurant.setTelephone((String)hashMap.get("telephone"));
        return restaurant;
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
}