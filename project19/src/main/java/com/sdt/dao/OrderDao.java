package com.sdt.dao;

import com.sdt.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {

    public void add(Order order);

    public List<Order> findAll();

    public void deleteById(Integer orderId);
}
