package com.sirius.feign;

import com.sirius.entity.Menu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "menu")
public interface MenuFeign {

    @GetMapping("/menu/findallbyrestname/{rname}")
    public List<Menu> findMenuByRestName(@PathVariable("rname") String rname);

//    @GetMapping("/findByRestaurantName/{rname}/{page}/{limit}")
//    List<Menu> findMenuByRestName(@PathVariable("rname") String rname, @PathVariable("page") int page, @PathVariable("limit") int limit);
//
    @GetMapping("/menu/findByRestaurantName/{rname}/{page}/{limit}")
    public List<Menu> findByRestaurantName(@PathVariable("rname") String rname, @PathVariable("page") int page, @PathVariable("limit") int limit);

    @PutMapping("/menu/update")
    public void update(@RequestBody Menu menu);

    @PostMapping("/menu/save")
    public void save(@RequestBody Menu menu);

    @GetMapping("/menu/findMenu/{rname}/{mname}")
    public List<Menu> findMenu(@PathVariable("rname") String rname, @PathVariable("mname") String mname);

}
