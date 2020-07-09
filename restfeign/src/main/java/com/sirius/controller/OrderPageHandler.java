package com.sirius.controller;

import com.sirius.entity.Order;
import com.sirius.entity.OrderDetail;
import com.sirius.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin
@RequestMapping("/restaurant/orderpage")
@RestController
public class OrderPageHandler {

    @Autowired
    private OrderFeign orderFeign;

    @CrossOrigin(allowCredentials="true", allowedHeaders="*", methods={RequestMethod.GET,
            RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS,
            RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.PATCH}, origins="*")
    @GetMapping("/findByRid/{rid}/{page}/{limit}")
    public List<Order> findByRid(@PathVariable("rid") int rid, @PathVariable("page") int page, @PathVariable("limit") int limit){
        return orderFeign.findByRid(rid,page,limit);
    }

    @CrossOrigin(allowCredentials="true", allowedHeaders="*", methods={RequestMethod.GET,
            RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS,
            RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.PATCH}, origins="*")
    @PutMapping("/updateByOid/{oid}/{state}")
    public void updateState(@PathVariable("oid") int oid, @PathVariable("state") int state){
        orderFeign.updateState(oid,state);
    }

    @CrossOrigin(allowCredentials="true", allowedHeaders="*", methods={RequestMethod.GET,
            RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS,
            RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.PATCH}, origins="*")
    @GetMapping("/findDetailByOid/{oid}")
    public Map<String,Object> findDetailByOid(@PathVariable("oid") int oid){
        Order order = orderFeign.findAnOrder(oid);
        List<OrderDetail> olist = orderFeign.findDetailByOid(oid);
        Map<String, Object> result = new HashMap<>();
        result.put("order",order);
        result.put("orderdetail", olist);
        return result;
    }



}
