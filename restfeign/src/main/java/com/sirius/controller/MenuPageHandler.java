package com.sirius.controller;

import com.sirius.entity.Menu;
import com.sirius.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/restaurant/menupage")
@RestController
public class MenuPageHandler {

    @Autowired
    private MenuFeign menuFeign;

    @CrossOrigin(allowCredentials="true", allowedHeaders="*", methods={RequestMethod.GET,
            RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS,
            RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.PATCH}, origins="*")
    @GetMapping("/findByRestaurantName/{rname}/{page}/{limit}")
    public List<Menu> findByRestaurantName(@PathVariable("rname") String rname, @PathVariable("page") int page, @PathVariable("limit") int limit){
        return menuFeign.findByRestaurantName(rname, page, limit);
    }

    @CrossOrigin(allowCredentials="true", allowedHeaders="*", methods={RequestMethod.GET,
            RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS,
            RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.PATCH}, origins="*")
    @PutMapping("/updateByMid")
    public void updateByMid(@RequestBody Menu menu){
        menuFeign.update(menu);
    }

    @CrossOrigin(allowCredentials="true", allowedHeaders="*", methods={RequestMethod.GET,
            RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS,
            RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.PATCH}, origins="*")
    @PostMapping("/save")
    public void save(@RequestBody Menu menu){
        menuFeign.save(menu);
    }

    @CrossOrigin(allowCredentials="true", allowedHeaders="*", methods={RequestMethod.GET,
            RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS,
            RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.PATCH}, origins="*")
    @GetMapping("/findByMenuName/{rname}/{mname}")
    public List<Menu> findByMenuName(@PathVariable("rname") String rname, @PathVariable("mname") String mname){
        return menuFeign.findMenu(rname, mname);
    }

}
