package com.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.pojo.*;
import com.service.NotifyUrlService;
import com.service.OrderService;
import com.util.HttpProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 提交订单
 */
@Controller
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    ObjectMapper objectMapper;

    @RequestMapping("/submit")
    @ResponseBody
    public Resp submit(Order order) throws Exception {
        Resp resp = new Resp();

        //检查日期
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(order.getTrain_date());
        Date today = new Date();
        String todayString = formatter.format(today);
        if(dateString.compareTo(todayString) < 0){
            resp.setError_code(217301);
            resp.setReason("参数错误：请不要输入一个今天以前的日期");
            return resp;
        }
        //检查passengers
        try{
            //url解码
            String passengersDecode = URLDecoder.decode(order.getPassengers(), "UTF-8");
            CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(List.class, OrderPassenger.class);
            List<OrderPassenger> list = objectMapper.readValue(passengersDecode,  listType);
            //todo 其它细节的检查
        }catch (Exception e){
            resp.setError_code(217301);
            resp.setReason("参数错误：未提供passengers参数或不是一个正确的json字符串");
            return resp;
        }

        int res=-1;
        try{
            res = orderService.add(order);
        }catch (Exception e){
            e.printStackTrace();
        }


        if(res==1){
            //异步调用占座回调的方法
            try{
                long id = Thread.currentThread().getId();
                orderService.sendNotify(order);
            }catch (Exception e){
                e.printStackTrace();
                resp.setError_code(217301);
                resp.setReason("回调出错");
                return resp;
            }

            resp.setError_code(0);
            resp.setReason("成功的返回");
            resp.setResult(order.getOrder_id());
        }else{
            resp.setError_code(217301);
            resp.setReason("参数错误");
        }

        return resp;
    }

}
