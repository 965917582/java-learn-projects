package com.sdt.service;

import com.sdt.domain.Order;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {

    public void generateOrder(List<Integer> goodsIdList, List<Integer> goodsNumList,List<BigDecimal> goodsPriceList, BigDecimal totalPrice, Integer userId);

    public List<Order> getOrdersByUserId(Integer userId);

    public void deleteOrderByOderId(Integer orderId);

    public void changePayStatusToTrue(Integer orderId);
}
