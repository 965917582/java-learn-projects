package com.sdt.service;

import com.sdt.domain.Order;
import java.util.List;

public interface OrderService {
    public void generateOrder(Integer[] checkComm);

    public List<Order> findAll();

    public void deleteOrder(Integer orderId);
}
