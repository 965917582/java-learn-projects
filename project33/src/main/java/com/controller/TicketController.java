package com.controller;

import com.pojo.Order;
import com.pojo.Resp;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 出票
 */
@Controller
public class TicketController {
    @Autowired
    OrderService orderService;

    @RequestMapping("/pay")
    @ResponseBody
    public Resp pay(String appkey,String orderid){
        Resp resp = new Resp();
        //订单是否存在
        Order order = orderService.findByUserOrderId(Integer.parseInt(orderid));
        if(order==null){
            resp.setError_code(217303);
            resp.setReason("订单号"+orderid+"不存在");
            return resp;
        }
        //订单状态是否是待支付(2)
        if(order.getStatus()!=2){
            resp.setError_code(217304);
            resp.setReason("只有占座成功（状态为2）的订单才可以支付，当前订单状态："+order.getStatus());
            return resp;
        }

        //订单状态设为已出票(4)
        int res = orderService.setStatusByOrderId(order.getOrder_id(), 4);
        if(res==1){
            //异步调用出票回调的方法
            try{
                orderService.sendTicktNotify(order);
            }catch (Exception e){
                e.printStackTrace();
                resp.setError_code(217301);
                resp.setReason("回调出错");
                return resp;
            }

            resp.setError_code(200);
            resp.setReason("成功的返回");
            return resp;

        }else{
            resp.setError_code(217305);
            resp.setReason("回调失败");
            return resp;
        }

    }

}
