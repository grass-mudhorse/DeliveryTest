package com.sirius.controller;


import com.sirius.entity.Account;
import com.sirius.entity.Admin;
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
@RequestMapping("/admin/account")
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
        Object obj = accountFeign.login(username,hashpassword,"admin");
        System.out.println(hashpassword);
        System.out.println("xxxxxxxxxxxxxxxx");
        if(obj == null) {
            //Log in failed
            hashmap.put("token","0");
            return hashmap;
        }
        else {
            //Log in successfully
            Admin admin = convertAdmin((LinkedHashMap<String, Object>) obj);
            hashmap.put("token","1");
            hashmap.put("admin",admin);
            return hashmap;
        }
    }

    public Admin convertAdmin(LinkedHashMap<String,Object> hashMap){
        Admin admin = new Admin();
        admin.setAdminid(((Integer)hashMap.get("adminid")).longValue());
        admin.setUsername((String)hashMap.get("username"));
        admin.setEmail((String)hashMap.get("email"));
        admin.setPassword((String)hashMap.get("password"));
        return admin;
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