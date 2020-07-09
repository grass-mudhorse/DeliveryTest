package com.sirius.feign;

import com.sirius.entity.Order;
import com.sirius.entity.OrderDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import com.sirius.entity.OrderDetail;

@FeignClient(value = "order")
public interface OrderFeign {
    @PostMapping("/order/save")
    public void makeOrder(@RequestBody Order order);

    @GetMapping("/order/findAll")
    public List<Order> findAllOrder();

    @PutMapping("/order/receiveaction/{oid}")
    public void receiveAction(@PathVariable("oid") long oid);

    @GetMapping("/order/findAllByRid/{rid}/{page}/{limit}")
    public List<Order> findByRid(@PathVariable("rid") int rid, @PathVariable("page") int page, @PathVariable("limit") int limit);

    @PutMapping("/order/updateState/{oid}/{state}")
    public void updateState(@PathVariable("oid") int oid, @PathVariable("state") int state);

    @GetMapping("/orderdetail/findByOrderID/{oid}")
    public List<OrderDetail> findDetailByOid(@PathVariable("oid") int oid);

    @GetMapping("/order/findAnOrder/{oid}")
    public Order findAnOrder(@PathVariable("oid") int oid);

}
