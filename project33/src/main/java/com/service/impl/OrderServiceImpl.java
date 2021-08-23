package com.service.impl;

import com.dao.OrderDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.pojo.NotifyUrl;
import com.pojo.Order;
import com.pojo.Resp;
import com.service.NotifyUrlService;
import com.service.OrderService;
import com.util.HttpClientUtils;
import com.util.HttpProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;
    @Autowired
    NotifyUrlService notifyUrlService;
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public int add(Order order) {
        return orderDao.add(order);
    }

    @Override
    @Async
    public void sendNotify(Order order){
        try{
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }

        long id = Thread.currentThread().getId();
        NotifyUrl notifyUrl = notifyUrlService.findByAppkey(order.getAppkey());
        Resp resp = new Resp();
        resp.setError_code(200);
        resp.setReason("提交订单的回调");
        resp.setResult(order);
        try{
//            String s = objectMapper.writeValueAsString(resp);
            /*Gson gson = new Gson();
            String s = gson.toJson(resp);*/
            //String http = HttpProtocol.http(notifyUrl.getSubmit_callback(),s ,"application/json");
            String s = HttpClientUtils.doGet(notifyUrl.getSubmit_callback());
            System.out.println(s);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        System.out.println("提交订单回调完成");
    }

    @Override
    @Async
    public void sendTicktNotify(Order order) {
        try{
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }


        NotifyUrl notifyUrl = notifyUrlService.findByAppkey(order.getAppkey());
        Resp resp = new Resp();
        resp.setError_code(200);
        resp.setReason("请求出票的回调");
        resp.setResult(order);
        try{
            //String s = objectMapper.writeValueAsString(resp);
            //String http = HttpProtocol.http(notifyUrl.getPay_callback(),"" ,"application/json");
            String s = HttpClientUtils.doGet(notifyUrl.getPay_callback());
            System.out.println(s);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        System.out.println("请求出票回调完成");
    }

    @Override
    public Order findByAppkey(String appkey) {
        return orderDao.findByAppkey(appkey);
    }

    @Override
    public int setStatusByOrderId(Integer orderId,Integer status) {
        return orderDao.setStatusByOrderId(orderId,status);
    }

    @Override
    public Order findByUserOrderId(Integer orderId) {
        return orderDao.findByUserOrderId(orderId);
    }
}
