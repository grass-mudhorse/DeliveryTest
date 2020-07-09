package com.sirius.repository;

import com.sirius.entity.OrderDetail;
import com.sirius.entity.OrderDetail;

import java.util.List;

public interface OrderDetailRepository {
    
    public List<OrderDetail> findAllDetail();

    public void deleteById(int id);

    void update(OrderDetail detail);

    void save(OrderDetail detail);

    List<OrderDetail> findByOrderID(int orderID);
}
