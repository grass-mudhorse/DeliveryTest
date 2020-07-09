package com.sirius.controller;

import com.sirius.entity.Order;
import com.sirius.entity.OrderDetail;
import com.sirius.entity.Review;
import com.sirius.feign.OrderFeign;
import com.sirius.feign.ReviewFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/client/order")
public class OrderHandler {
    @Autowired
    private OrderFeign orderFeign;

    @Autowired
    private ReviewFeign reviewFeign;

    @CrossOrigin(allowCredentials="true", allowedHeaders="*", methods={RequestMethod.GET,
            RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS,
            RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.PATCH}, origins="*")
    @GetMapping("/findallbyuid/{uid}")
    public List<Order> findAllByUid(@PathVariable("uid") int uid){
        return orderFeign.findAllByUid(uid);
    }

    @PutMapping("/receiveaction/{oid}")
    public void receiveAction(@PathVariable long oid){
        orderFeign.receiveAction(oid);
    }

    @PostMapping("/commentaction")
    public void commentAction(@RequestBody Review review){
        reviewFeign.addReview(review);
        orderFeign.commentAction(review.getOrderid());
    }

    @GetMapping("/orderdetail/{oid}")
    public Map<String,Object> orderDetail(@PathVariable long oid){
        Map<String,Object> hashmap = new HashMap<String,Object>();
        Order order = orderFeign.findByOid(oid);
        invertOrderToMap(hashmap,order);
        List<OrderDetail> orderdetails = orderFeign.findDetailByOid(oid);
        hashmap.put("orderdetails",orderdetails);
        return hashmap;
    }

    public void invertOrderToMap(Map hashmap,Order order){
        hashmap.put("orderid",order.getOrderid());
        hashmap.put("restaurantid",order.getRestaurantid());
        hashmap.put("userid",order.getUserid());
        hashmap.put("date",order.getUserid());
        hashmap.put("totalprice",order.getTotalprice());
        hashmap.put("state",order.getState());
        hashmap.put("note",order.getNote());
        hashmap.put("address",order.getAddress());
        hashmap.put("arrivingtime",order.getArrivingtime());
    }

}
