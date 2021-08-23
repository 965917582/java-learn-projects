package com.sdt.test;

import com.sdt.util.HttpProtocol;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("out_trade_no",1+"");
        map.put("total_amount",20.5+"");
        map.put("subject","chepiao");
        map.put("return_url","http://aijia.free.idcfengye.com/paysuccessPage");
        map.put("notify_url","");
        String http = HttpProtocol.http("http://8.210.142.190:8080/mvnweb/zfb/zfbpay", map);
        System.out.println(http);


    }
}
