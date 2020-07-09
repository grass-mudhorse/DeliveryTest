package com.sirius.controller;

import com.sirius.entity.User;
import com.sirius.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RequestMapping("/admin/userpage")
@RestController
public class UserHandler {


    @Autowired
    private UserFeign userFeign;


    @CrossOrigin(allowCredentials = "true",allowedHeaders = "*",methods = {RequestMethod.GET,
    RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.PUT,
    RequestMethod.PATCH}, origins="*")
    @GetMapping("/findAllUser/{index}/{limit}")
    public List<User> findAllUser(@PathVariable("index") int index, @PathVariable("limit") int limit){
        return userFeign.findAllUser(index, limit);
    }

    @CrossOrigin(allowCredentials = "true",allowedHeaders = "*",methods = {RequestMethod.GET,
     RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.PUT,
     RequestMethod.PATCH}, origins="*")
    @GetMapping("/findByUid/{userid}")
    public List<User> findByUid(@PathVariable("userid") int userid){
        return userFeign.findByUid(userid);
    }


    @CrossOrigin(allowCredentials = "true",allowedHeaders = "*",methods = {RequestMethod.GET,
     RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.PUT,
     RequestMethod.PATCH}, origins="*")
    @GetMapping("/deleteByUid/{userid}")
    public void deleteByUid(@PathVariable("userid") int userid){
        userFeign.deleteByUid(userid);
    }


    @CrossOrigin(allowCredentials = "true",allowedHeaders = "*",methods = {RequestMethod.GET,
     RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.PUT,
     RequestMethod.PATCH}, origins="*")
    @PutMapping("/updateByUid")
    public void updateByUid(@RequestBody User user)throws NoSuchAlgorithmException{
        user.setPassword(hashPassword(user.getPassword()));
        userFeign.updateByUid(user);
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
