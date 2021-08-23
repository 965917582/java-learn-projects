package com.sdt.service.impl;

import com.sdt.dao.OrderDao;
import com.sdt.dao.OrderDetailDao;
import com.sdt.domain.Order;
import com.sdt.domain.OrderDetail;
import com.sdt.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;
    @Autowired
    OrderDetailDao orderDetailDao;
    @Autowired
    Jedis jedis;

    @Override
    public void generateOrder(List<Integer> goodsIdList, List<Integer> goodsNumList,List<BigDecimal> goodsPriceList, BigDecimal totalPrice, Integer userId) {
        //封装order的bean
        Order order = new Order();
        order.setOrderCreateTime(new Date());
        order.setOrderTotalPrice(totalPrice);
        order.setUserId(userId);
        //存入数据库后返回订单id
        orderDao.add(order);

        //封装orderDetail的bean
        for(int i=0;i<goodsIdList.size();i++){
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(order.getOrderId());
            orderDetail.setGoodsId(goodsIdList.get(i));
            orderDetail.setGoodsNum(goodsNumList.get(i));
            orderDetail.setGoodsPrice(goodsPriceList.get(i));

            orderDetailDao.add(orderDetail);

            //从redis删除选中商品
            //此用户：此商品
            jedis.hdel(userId+"",goodsIdList.get(i)+"");
        }


    }

    @Override
    public List<Order> getOrdersByUserId(Integer userId) {
        return orderDao.getOrdersByUserId(userId);
    }

    @Override
    public void deleteOrderByOderId(Integer orderId) {
        //删除订单详情(先)
        orderDetailDao.deleteByOrderId(orderId);
        //删除订单
        orderDao.deleteByOrderId(orderId);

    }

    @Override
    public void changePayStatusToTrue(Integer orderId) {
        orderDao.changePayStatusToTrue(orderId);
    }
}
