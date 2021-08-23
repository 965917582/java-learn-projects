package com.service;

import com.pojo.Order;

public interface OrderService {
    int add(Order order);

    void sendNotify(Order order);

    void sendTicktNotify(Order order);

    Order findByAppkey(String appkey);

    int setStatusByOrderId(Integer orderId,Integer status);

    Order findByUserOrderId(Integer orderId);
}
