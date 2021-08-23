package com.sdt.dao;

import com.sdt.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderDao {

    public void add(Order order);

    public List<Order> getOrdersByUserId(Integer userId);

    public void deleteByOrderId(Integer orderId);

    public void changePayStatusToTrue(Integer orderId);

}
