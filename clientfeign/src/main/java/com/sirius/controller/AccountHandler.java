package com.sirius.controller;


import com.sirius.entity.Account;
import com.sirius.entity.User;
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
@RequestMapping("/client/account")
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
        String hashpassword = hashPassword(password);
        Object obj = accountFeign.login(username,hashpassword,"user");
        System.out.println(hashpassword);
        if(obj == null) {
            //Log in failed
            hashmap.put("token","0");
            return hashmap;
        }
        else {
            //Log in successfully
            User user = convertUser((LinkedHashMap<String, Object>) obj);
            hashmap.put("token","1");
            hashmap.put("user",user);
            return hashmap;
        }
    }

    public User convertUser(LinkedHashMap<String,Object> hashMap){
        User user = new User();
        user.setUserid(((Integer)hashMap.get("userid")).longValue());
        user.setUsername((String)hashMap.get("username"));
        user.setNickname((String)hashMap.get("nickname"));
        user.setTelephone((String)hashMap.get("telephone"));
        user.setAddress((String)hashMap.get("address"));
        user.setPassword((String)hashMap.get("password"));
        return user;
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