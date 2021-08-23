package com.sdt.service;

import com.sdt.domain.Order;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {

    public void generateOrder(String goodsIdList,String goodsNumList, String goodsPriceList,BigDecimal totalPrice, Integer userId);

    public List<Order> getOrdersByUserId(Integer userId);

    public void deleteOrderByOderId(Integer orderId);

    public void changePayStatusToTrue(Integer orderId);

    public void deleteOrderByGoodsId(Integer orderId,Integer goodsId);
}
