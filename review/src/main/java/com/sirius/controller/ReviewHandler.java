package com.sirius.controller;

import com.sirius.entity.Review;
import com.sirius.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("/review")
@RestController
public class ReviewHandler {
    @Value("${server.port}")
    private String port;

    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/index")
    public String index(){
        return this.port;
    }

//    @GetMapping("/findByRestName/{rname}")
//    public List<Review> findByRestName(@PathVariable("rname") String rname){
//        return reviewRepository.findByRestName(rname);
//    }

    @GetMapping("/findReviewByRestaurantId/{restaurantid}/{index}/{limit}")
    public List<Review> findReviewByRestaurantId(@PathVariable("restaurantid") int restaurantid, @PathVariable("index") int index, @PathVariable("limit") int limit){
        return reviewRepository.findReviewByRestaurantId(restaurantid, (index-1)*limit, limit);
    }

//    @GetMapping("/findAllUser/{index}/{limit}")
//    public List<User> findAllUser(@PathVariable("index") int index, @PathVariable("limit") int limit){
//        return userRepository.findAllUser((index-1)*limit, limit);
//    }

    @GetMapping("/findByRestId/{id}")
    public List<Review> findByRestId(@PathVariable("id") int id){
        return reviewRepository.findByRestId(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Review review){
        Date date = new Date();
        review.setDate(date);
        reviewRepository.save(review);
    }

    @DeleteMapping("/deleteByReviewId/{reviewid}")
    public void deleteByReviewId(@PathVariable("reviewid") long reviewid){
        reviewRepository.deleteByReviewId(reviewid);
    }
}
