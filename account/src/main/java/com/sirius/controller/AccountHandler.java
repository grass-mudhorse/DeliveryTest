package com.sirius.controller;

import com.sirius.entity.Account;
import com.sirius.entity.Restaurant;
import com.sirius.repository.AdminRepository;
import com.sirius.repository.RestRepository;
import com.sirius.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/account")
@RestController
public class AccountHandler {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private RestRepository restRepository;

    @Value("${server.port}")
    private String port;

    @GetMapping("/port")
    public String port(){
        return this.port;
    }

    @GetMapping("login/{username}/{password}/{type}")
    public Object login(@PathVariable("username") String username,@PathVariable("password") String password,@PathVariable("type") String type){
        Account account =null;
        switch(type){
            case "user":
                account = userRepository.login(username,password);
                break;
            case "admin":
                account = adminRepository.login(username,password);
                break;
            case "restaurant":
                account = restRepository.login(username,password);
                break;
        }
        return account;
    }

    @GetMapping("/findallrest")
    public List<Restaurant> findAllRestaurant(){
        return restRepository.findAllRestaurant();
    }

    @GetMapping("/findbyrname/{rname}")
    public Restaurant findByRname(@PathVariable String rname){
        return restRepository.findByRname(rname);
    }

}
