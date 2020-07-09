package com.sirius.feign;

import com.sirius.entity.Restaurant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "user")
public interface UserFeign {

    @GetMapping("/user/findByRid/{rid}")
    public List<Restaurant> findByRid(@PathVariable("rid") int rid);

    @PutMapping("/user/updateByRid")
    public void updateByRid(@RequestBody Restaurant restaurant);
}
