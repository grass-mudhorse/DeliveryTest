package com.sirius.feign;

import com.sirius.entity.Order;
import com.sirius.entity.OrderDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "order")
public interface OrderFeign {
    @PostMapping("/order/save")
    public long makeOrder(@RequestBody Order order);

    @GetMapping("order/findAllByUid/{uid}")
    public List<Order> findAllByUid(@PathVariable("uid") int uid);

    @PutMapping("/order/receiveaction/{oid}")
    public void receiveAction(@PathVariable("oid") long oid);

    @PutMapping("/order/commentaction/{oid}")
    public void commentAction(@PathVariable("oid") long oid);

    @GetMapping("/order/findByOid/{oid}")
    public Order findByOid(@PathVariable("oid") long oid);

    @GetMapping("/orderdetail/findByOrderID/{orderID}")
    public List<OrderDetail> findDetailByOid(@PathVariable("orderID") long oid);

    @PostMapping("/orderdetail/save")
    public void saveOrderDetail(@RequestBody OrderDetail orderDetail);

}
