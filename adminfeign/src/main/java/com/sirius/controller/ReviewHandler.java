package com.sirius.controller;

import com.sirius.entity.Review;
import com.sirius.feign.ReviewFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/reviewpage")
public class ReviewHandler {

    @Autowired
    private ReviewFeign reviewFeign;
    @CrossOrigin(allowCredentials = "true",allowedHeaders = "*",methods = {RequestMethod.GET,
            RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.PUT,
            RequestMethod.PATCH}, origins="*")
    @GetMapping("/findReviewByRestaurantId/{restaurantid}/{index}/{limit}")
    public List<Review> findReviewByRestaurantId(@PathVariable("restaurantid") int restaurantid, @PathVariable("index") int index, @PathVariable("limit") int limit){
        return reviewFeign.findReviewByRestaurantId(restaurantid, index, limit);
    }
    @CrossOrigin(allowCredentials = "true",allowedHeaders = "*",methods = {RequestMethod.GET,
            RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.PUT,
            RequestMethod.PATCH}, origins="*")
    @DeleteMapping("/deleteByReviewId/{reviewid}")
    public void deleteByReviewId(@PathVariable long reviewid){
        reviewFeign.deleteByReviewId(reviewid);
    }

}
