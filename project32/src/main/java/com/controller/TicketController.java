package com.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.Passenger;
import com.pojo.Passengers;
import com.pojo.Torder;
import com.service.OrderService;
import com.util.HttpClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TicketController {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    OrderService orderService;

    //获取所有站点
    @RequestMapping(value = "/getStation",produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String getStation(){
        String stations = HttpClientUtils.doGet("http://op.juhe.cn/trainTickets/cityCode?dtype=&stationName=&all=1&key=c183f00ee2422d7dbe146592d9824cdd");
        //向接口设置回调http://47.243.23.197:8080/project33/setPush?appkey=test
        //HttpClientUtils.doGet("http://47.243.23.197:8080/project33/setPush?appkey=test");

        //HttpClientUtils.doGet("http://47.243.23.197:8080/project33/setPush?appkey=c183f00ee2422d7dbe146592d9824cdd&submit_callback=http://localhost:8080/project32/orderBack&pay_callback=http://localhost:8080/project32/ticketBack&refund_callback=null");
        //HttpClientUtils.doGet("http://localhost:8081/trainTickets/setPush?appkey=c183f00ee2422d7dbe146592d9824cdd&submit_callback=http://aijia.free.idcfengye.com/project32/orderBack&pay_callback=http://aijia.free.idcfengye.com/project32/ticketBack&refund_callback=null");
        Map<String, String> param = new HashMap<>();
        param.put("appkey","c183f00ee2422d7dbe146592d9824cdd");
        param.put("submit_callback","http://aijia.free.idcfengye.com/project32/orderBack");
        param.put("pay_callback","http://aijia.free.idcfengye.com/project32/ticketBack");
        HttpClientUtils.doPost("http://aijia.free.idcfengye.com/trainTickets/setPush",param);
        //HttpClientUtils.doPost("http://47.243.23.197:8080/project33/setPush?appkey=c183f00ee2422d7dbe146592d9824cdd&submit_callback=http://aijia.free.idcfengye.com/project32/orderBack&pay_callback=http://aijia.free.idcfengye.com/project32/ticketBack&refund_callback=null",null);

        return stations;
    }

    //余票查询
        @RequestMapping(value = "/ticketsAvailable",produces = "text/html; charset=UTF-8")
        @ResponseBody
        public String ticketsAvailable(String fromStation, String toStation, @RequestParam("goTime") @DateTimeFormat(pattern = "yyyy-MM-dd")Date goTime){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(goTime);
        String availabletickets = HttpClientUtils.doGet("http://op.juhe.cn/trainTickets/ticketsAvailable?train_date=" + dateString + "&from_station=" + fromStation + "&to_station=" + toStation+"&key=c183f00ee2422d7dbe146592d9824cdd");
        return availabletickets;
    }

    //实名身份认证
    @RequestMapping(value = "/trainidverification",produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String trainidverification(Passenger passenger) throws JsonProcessingException, UnsupportedEncodingException {
        Passengers passengers = new Passengers();
        passengers.getPassengers().add(passenger);
        String passengersstr = objectMapper.writeValueAsString(passengers);
        //String encode = URLEncoder.encode("{'passengers':[{'passenger_name':'刘媛媛','email':'965917582@qq.com','passenger_id_type_code':'1','passenger_id_type_name':'二代身份证','passenger_id_no':'370112199705083922','encMobileNo':'15650050924'}]}", "UTF-8");
        String encode = URLEncoder.encode(passengersstr, "UTF-8");
        //post请求的参数map
        /*HashMap<String, String> map = new HashMap<>();
        map.put("data",encode);
        map.put("key","c183f00ee2422d7dbe146592d9824cdd");
        String res = HttpClientUtils.doPost("https://op.juhe.cn/trainTickets/trainidverification", map);*/

        String res = HttpClientUtils.doGet("https://op.juhe.cn/trainTickets/trainidverification?dtype=&data="+encode+"&key=c183f00ee2422d7dbe146592d9824cdd");
        if(res.contains("已通过")){
            return "ok";
        }else{
            return "fail";
        }
    }


    @RequestMapping(value = "/generateOrder",produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String generateOrder(HttpServletRequest req,Torder order) throws UnsupportedEncodingException {
        //向项目数据库提交订单
        orderService.add(req,order);
        //向接口提交订单
        String url = "http://aijia.free.idcfengye.com/trainTickets/submit?";
        //String url = "http://47.243.23.197:8080/project33/submit?";
        //String url = "http://47.243.23.197:8080/project33/submit?";
        url = url+"appkey=c183f00ee2422d7dbe146592d9824cdd";
        url = url+"&user_order_id="+order.getOrder_id();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(order.getTrain_date());
        url = url+"&train_date="+dateString;
        //url = url+"&user_orderid="+order.getIs_accept_standing();
        //url = url+"&user_orderid="+order.getChoose_seats();
        url = url+"&from_station_code="+order.getFrom_station_code();
        url = url+"&to_station_code="+order.getTo_station_code();
        url = url+"&checi="+order.getCheci();
        //测试数据
        //发送get请求需要进行url编码
        url = url+"&paymentAccount="+URLEncoder.encode("{\"name\": \"刘媛媛\",\"passportNo\": \"370112199705083922\",\"bankCardMobile\": \"15650050924\",\"bankCardNo\": \"6228270251228210574\"}", "UTF-8");
        url = url+"&passengers="+URLEncoder.encode("[{\"phoneNum\":\"15650050924\",\"email\":\"965917582@qq.com\",\"passengerid\":1,\"passengersename\":\"刘媛媛\",\"piaotype\":\"1\",\"piaotypename\":\"成人票\",\"passporttypeseid\":\"1\",\"passporttypeseidname\":\"二代身份证\",\"passportseno\":\"370112199705083922\",\"price\":\"763.5\",\"zwcode\":\"M\",\"zwname\":\"一等座\"}]", "UTF-8");


        String res = HttpClientUtils.doGet(url);
        if(res.contains("成功的返回")){
            return "success";
        }else{
            return "fail";
        }

    }

    //出票
    @RequestMapping(value = "/outTicket")
    @ResponseBody
    public String outTicket(String orderid) {
        //String res = HttpClientUtils.doGet("http://47.243.23.197:8080/project33/pay?appkey=c183f00ee2422d7dbe146592d9824cdd&orderid="+orderid);
        Map<String, String> param = new HashMap<>();
        param.put("appkey","c183f00ee2422d7dbe146592d9824cdd");
        param.put("orderid",orderid);

        //String res = HttpClientUtils.doGet("http://localhost:8081/trainTickets/pay?appkey=c183f00ee2422d7dbe146592d9824cdd&orderid="+orderid);
        //String res = HttpClientUtils.doPost("http://47.243.23.197:8080/project33/pay?appkey=c183f00ee2422d7dbe146592d9824cdd&orderid="+orderid,null);

        //String res = HttpClientUtils.doPost("http://47.243.23.197:8080/project33/pay",param);\
        String res = HttpClientUtils.doPost("http://aijia.free.idcfengye.com/trainTickets/pay",param);
        if(res.contains("成功的返回")){
            return "success";
        }else{
            return "fail";
        }
    }



    //提交订单回调
    @RequestMapping(value = "/orderBack")
    public void orderBack(){
        System.out.println("提交订单回调");
    }

    //出票回调
    @RequestMapping(value = "/ticketBack")
    public void ticketBack(){
        System.out.println("出票回调");
    }


}
