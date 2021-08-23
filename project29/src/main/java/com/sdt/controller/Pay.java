package com.sdt.controller;


import com.github.wxpay.sdk.WXPayUtil;
import com.sdt.pojo.Key;
import com.sdt.util.HttpClientUtils;
import com.sdt.util.SignUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class Pay {

    @RequestMapping("/pay")
    @ResponseBody
    public String pay(HttpServletRequest req,String out_trade_no, String total_fee) throws Exception {
        Key.setNonce_str(SignUtil.getRandomString(10));
        Key.setSpbill_create_ip(SignUtil.getIpAddr(req));

        TreeMap<String, String> map = new TreeMap<>();
        map.put("appid",Key.getAppid());
        map.put("mch_id", Key.getMch_id());
        map.put("nonce_str",Key.getNonce_str() );
        map.put("body",Key.getBody() );
        map.put("spbill_create_ip", Key.getSpbill_create_ip());
        map.put("notify_url",Key.getNotify_url() );
        //map.put("redirect_url",Key.getRedirect_url() );
        map.put("trade_type", Key.getTrade_type());
        map.put("out_trade_no", out_trade_no);
        map.put("total_fee", total_fee);

        //签名
        String sign = WXPayUtil.generateSignature(map, Key.getKey());
        /*String text = SignUtil.map_to_string(map);
        text=text+Key.getKey();
        String sign = SignUtil.MD5(text);*/

        map.put("sign", sign);

        //转成xml格式的字符串
        String xml = WXPayUtil.mapToXml(map);
        //发送请求
        String resp = HttpClientUtils.doPostByXml(Key.getReqUrl(),xml);
        Map<String, String> respMap = WXPayUtil.xmlToMap(resp);
        return respMap.get("mweb_url");

    }

    @RequestMapping("notify")
    @ResponseBody
    public String back(){
        System.out.println("后台回调");
        return "success";
    }

    @RequestMapping("redirect")
    public String redirect(){
        return "paidPage";
    }
}
