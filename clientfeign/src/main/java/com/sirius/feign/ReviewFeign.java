package com.sirius.feign;

import com.sirius.entity.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "review")
public interface ReviewFeign {
    @PostMapping("/review/save")
    public void addReview(@RequestBody Review review);

    @GetMapping("/review/findByRestName/{rname}")
    public List<Review> findByRestName(@PathVariable String rname);

    @GetMapping("/review/findReviewByRestaurantId/{restaurantid}/{index}/{limit}")
    public List<Review> findReviewByRestaurantId(@PathVariable("restaurantid") int restaurantid, @PathVariable("index") int index, @PathVariable("limit") int limit);



    @DeleteMapping("/review/deleteByReviewId/{reviewid}")
    public void deleteByReviewId(@PathVariable long reviewid);
}
