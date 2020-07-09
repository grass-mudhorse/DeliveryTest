package com.sirius.controller;

import com.sirius.entity.OrderDetail;
import com.sirius.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderdetail")
public class OrderDetailHandler {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @GetMapping("/findAllDetail")
    public List<OrderDetail> findAllDetail(){
        return orderDetailRepository.findAllDetail();
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") int id){
        orderDetailRepository.deleteById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody OrderDetail detail){
        orderDetailRepository.update(detail);
    }

    @PostMapping("/save")
    public void save(@RequestBody OrderDetail detail){
        System.out.println(detail);
        orderDetailRepository.save(detail);
    }

    @GetMapping("/findByOrderID/{orderID}")
    public List<OrderDetail> findByOrderID(@PathVariable("orderID") int orderID){
        return orderDetailRepository.findByOrderID(orderID);
    }
}
