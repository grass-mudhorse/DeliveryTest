package com.sirius.feign;

import com.sirius.entity.Restaurant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "account")
public interface AccountFeign {

    @GetMapping("/account/login/{username}/{password}/{type}")
    public Object login(@PathVariable("username") String username,@PathVariable("password") String password,@PathVariable("type") String type);

    @GetMapping("/account/findallrest")
    public List<Restaurant> findAllRestaurant();

    @GetMapping("/account/findbyrname/{rname}")
    public Restaurant findRestaurantByRname(@PathVariable("rname") String rname);

}
