package com.sirius.controller;

import com.sirius.entity.Menu;
import com.sirius.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/menu")
@RestController
public class MenuHandler {
    @Value("${server.port}")
    private String port;

    @Autowired
    private MenuRepository menuRepository;

    @GetMapping("/index")
    public String index(){
        return this.port;
    }

    @GetMapping("/findAll/{index}/{limit}")
    public List<Menu> findAll(@PathVariable("index") int index, @PathVariable("limit") int limit){
        return menuRepository.findAll(index, limit);
    }

    @GetMapping("/findByRestaurantName/{rname}/{page}/{limit}")
    public List<Menu> findByRestaurantName(@PathVariable("rname") String rname, @PathVariable("page") int page, @PathVariable("limit") int limit){
        return menuRepository.findByRestaurantName(rname, (page-1)*limit, limit);
    }
    @GetMapping("findMenuByRestName/{rname}")
    public List<Menu> findMenuByRestName(@PathVariable("rname") String rname){
        return menuRepository.findMenuByRestName(rname);
    }

    @GetMapping("/findAllByMId/{id}")
    public Menu findById(@PathVariable("id") int id){
        return menuRepository.findAllByMId(id);
    }

    @GetMapping("/findMenu/{rname}/{mname}")
    public List<Menu> findMenu(@PathVariable("rname") String rname,@PathVariable("mname") String mname){
        return menuRepository.findMenu(rname, mname);
    }

    @DeleteMapping("/deleteByName/{rname}/{mname}")
    public void deleteByName(@PathVariable("rname") String rname,@PathVariable("mname") String mname){
        menuRepository.deleteByName(rname, mname);
    }

    @PostMapping("/save")
    public void save(@RequestBody Menu menu){
        menuRepository.save(menu);
    }

    @PutMapping("/update")
    public void update(@RequestBody Menu menu){
        menuRepository.update(menu);
    }
}
