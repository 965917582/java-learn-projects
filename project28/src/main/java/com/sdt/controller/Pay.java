package com.sdt.controller;

import com.alibaba.fastjson.JSON;
import com.sdt.pojo.Key;
import com.sdt.pojo.ReqPram;
import com.sdt.util.SignUtil;
import com.sdt.util.ToForm;
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
    public String pay(ReqPram reqPram) throws Exception {
        TreeMap<String, String> map = new TreeMap<>();
        //设置请求参数到Key类
        String biz_content = JSON.toJSONString(reqPram);
        Key.setBiz_content(biz_content);
        Key.setTimestamp("2014-07-24 03:07:50");

        //存入treemap
        keyToMap(map);
        //先转成form格式再生成签名
        String text = SignUtil.map_to_string(map);

        //生成签名
        String signqm = SignUtil.signqm(text, Key.getPrivateKey());
        map.put("sign",signqm);

        //生成表单
        String reqUrl = "https://openapi.alipaydev.com/gateway.do";//沙箱的接口
        String form = ToForm.from(reqUrl, map);
        System.out.println(form);
        return form;
    }


    //前台回调
    @RequestMapping("/toPaidPage")
    public String toPaidPage(HttpServletRequest req){
        //验签
        /*Map parameterMap = req.getParameterMap();
        String s = SignUtil.map_quchu_signandsigntype(parameterMap);
        boolean sign = SignUtil.yansign(Key.getAliPublicKey(), req.getParameter("sign"), s);*/
        boolean succ = SignUtil.checkSign(req);
        if(succ){
            return "paidPage";
        }else{
            return "paidError";
        }

    }

    //后台回调
    @RequestMapping("/handleOrder")
    @ResponseBody
    public String handleOrder(){

        return "success";
    }

    private void keyToMap(Map map){
        map.put("app_id",Key.getApp_id());
        map.put("method",Key.getMethod());
        map.put("return_url",Key.getReturn_url());
        map.put("notify_url",Key.getNotify_url());
        map.put("charset",Key.getCharset());
        map.put("sign_type",Key.getSign_type());
        map.put("version",Key.getVersion());
        map.put("timestamp",Key.getTimestamp());
        map.put("biz_content",Key.getBiz_content());
    }
}

