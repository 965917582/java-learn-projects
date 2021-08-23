package com.sdt.service.impl;

import com.sdt.dao.CommOrderDao;
import com.sdt.dao.CommoditDao;
import com.sdt.dao.OrderDao;
import com.sdt.domain.CommOrder;
import com.sdt.domain.Commodit;
import com.sdt.domain.Order;
import com.sdt.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;
    @Autowired
    CommOrderDao commOrderDao;
    @Autowired
    Jedis jedis;

    @Override
    public void generateOrder(Integer[] checkComm) {
        //根据参数得到order对象
        Order order = new Order();
        order.setOrderSubmitTime(new Date());

        //"插入订单并返回新插入的id
        orderDao.add(order);
        //插入商品-订单
        CommOrder commOrder = new CommOrder();
        for (Integer commId : checkComm) {
            commOrder.setCommId(commId);
            commOrder.setOrderId(order.getOrderId());
            String commoditNum = jedis.hget(commId + "", "commoditNum");
            commOrder.setCommOrderNum(Integer.parseInt(commoditNum));
            commOrderDao.add(commOrder);
        }

        //清除缓存
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            jedis.hdel(key,"commoditId");
            jedis.hdel(key,"commoditName");
            jedis.hdel(key,"commoditPrice");
            jedis.hdel(key,"commoditNum");
        }
    }

    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }

    /**
     * 删除订单：
     * 删除中间表comm_order表相关数据
     * 删除order表订单数据
     */
    @Override
    public void deleteOrder(Integer orderId) {
        commOrderDao.deleteOrderById(orderId);
        orderDao.deleteById(orderId);
    }
}
