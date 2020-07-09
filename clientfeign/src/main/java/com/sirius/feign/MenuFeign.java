package com.sirius.feign;

import com.sirius.entity.Menu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "menu")
public interface MenuFeign {

    @GetMapping("/menu/findMenuByRestName/{rname}")
    public List<Menu> findMenuByRestName(@PathVariable("rname") String rname);
}
