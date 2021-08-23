package com.sdt.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdt.dao.OrderDao;
import com.sdt.dao.OrderDetailDao;
import com.sdt.domain.Order;
import com.sdt.domain.OrderDetail;
import com.sdt.service.OrderService;
import com.sdt.util.JedisUtils;
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
    Jedis jedis  = JedisUtils.getJedis();
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void generateOrder(String goodsIdList, String goodsNumList, String goodsPriceList, BigDecimal totalPrice, Integer userId) {
        //封装order的bean
        Order order = new Order();
        order.setOrderCreateTime(new Date());
        order.setOrderTotalPrice(totalPrice);
        order.setUserId(userId);
        //存入数据库后返回订单id
        orderDao.add(order);

        //把参数（json字符串）转进list
        List<Integer> goodsIdList2 = null;
        List<Integer> goodsNumList2 = null;
        List<BigDecimal> goodsPriceList2 = null;
        try{
            goodsIdList2 = objectMapper.readValue(goodsIdList, new TypeReference<List<Integer>>() {});
            goodsNumList2 = objectMapper.readValue(goodsNumList, new TypeReference<List<Integer>>() {});
            goodsPriceList2 = objectMapper.readValue(goodsPriceList, new TypeReference<List<BigDecimal>>() {});
        }catch (Exception e){
            e.printStackTrace();
        }




        //封装orderDetail的bean
        for(int i=0;i<goodsIdList2.size();i++){
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(order.getOrderId());
            orderDetail.setGoodsId(goodsIdList2.get(i));
            orderDetail.setGoodsNum(goodsNumList2.get(i));
            orderDetail.setGoodsPrice(goodsPriceList2.get(i));

            orderDetailDao.add(orderDetail);

            //从redis删除选中商品
            //此用户：此商品
            jedis.hdel(userId+"",goodsIdList2.get(i)+"");
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

    @Override
    public void deleteOrderByGoodsId(Integer orderId, Integer goodsId) {
        orderDetailDao.deleteOrderByGoodsId(orderId,goodsId);
    }
}
