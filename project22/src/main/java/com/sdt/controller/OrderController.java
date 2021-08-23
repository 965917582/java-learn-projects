package com.sdt.controller;

import com.alibaba.fastjson.JSON;
import com.sdt.domain.Order;
import com.sdt.domain.Response;
import com.sdt.domain.ResponseMsg;
import com.sdt.service.OrderService;
import com.sdt.util.HttpProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    //调用支付宝接口，返回支付二维码
    @RequestMapping("/pay")
    @ResponseBody
    public String pay(Integer orderId,BigDecimal totalPrice) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("out_trade_no",orderId+"");
        map.put("total_amount",totalPrice+"");
        String subject = "order"+System.currentTimeMillis();
        map.put("subject",subject);
        map.put("return_url","http://aijia.free.idcfengye.com/project22/order/paysuccessPage");
        map.put("notify_url","http://aijia.free.idcfengye.com/project22/order/changePayStatus");
        String http = HttpProtocol.http("http://8.210.142.190:8080/mvnweb/zfb/zfbpay", map);
        System.out.println(http);
        Response response = JSON.parseObject(http, Response.class);
        String data = response.getData();
        return data;
    }


    //跳转支付成功页面
    @RequestMapping("/paysuccessPage")
    public String paysuccessPage(){
        return "paysuccess";
    }

    //支付成功后修改支付状态
    @RequestMapping("/changePayStatus")
    @ResponseBody
    public String changePayStatus(@RequestParam(value = "out_trade_no") String out_trade_no, HttpServletRequest req){
        orderService.changePayStatusToTrue(Integer.parseInt(out_trade_no));
        return "{'code':'success','msg':'success','data':'success'}";
    }

    @RequestMapping("/generateOrder")
    @ResponseBody
    public ResponseMsg generateOrder(@RequestParam(value = "goodsIdList[]")List<Integer> goodsIdList
                                    , @RequestParam(value = "goodsNumList[]")List<Integer> goodsNumList
                                    , @RequestParam(value = "goodsPriceList[]")List<BigDecimal> goodsPriceList
                                    , BigDecimal totalPrice,Integer userId){

        orderService.generateOrder(goodsIdList,goodsNumList,goodsPriceList,totalPrice,userId);

        ResponseMsg msg = new ResponseMsg();
        msg.setCode("200");
        msg.setMsg("已生成订单");
        return msg;
    }


    @RequestMapping("/getAllOrder")
    @ResponseBody
    public ResponseMsg getAllOrder(Integer userId){
        List<Order> orders = orderService.getOrdersByUserId(userId);

        ResponseMsg msg = new ResponseMsg();
        msg.setData(orders);
        msg.setCode("200");
        msg.setMsg("用户"+userId+"的全部订单");
        return msg;
    }

    @RequestMapping("/deleteOrderByOrderId")
    @ResponseBody
    public ResponseMsg deleteOrderByOrderId(Integer orderId){
        orderService.deleteOrderByOderId(orderId);

        ResponseMsg msg = new ResponseMsg();
        msg.setCode("200");
        msg.setMsg("已删除"+orderId+"号订单");
        return msg;
    }


}
