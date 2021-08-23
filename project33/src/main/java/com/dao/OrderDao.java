package com.dao;

import com.pojo.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao {
    int add(Order order);

    Order findByAppkey(String appkey);

    Order findByUserOrderId(Integer orderId);

    int setStatusByOrderId(Integer orderId,Integer status);
}
