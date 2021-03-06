package controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
public class WeixinPayWap {
    @ResponseBody
    @RequestMapping(value = "/pay" ,produces = { "application/json;charset=UTF-8" })
    public String weixinPayWap(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        String APPID = "你的apid";
        String MERID = "你的商户号";
        String SIGNKEY = "你的商户密钥";
        String spbill_create_ip = getIpAddr(request);//生产
        System.out.println("spbill_create_ip="+spbill_create_ip);
        //String spbill_create_ip = "";//测试地址，也就是本地真是ip，用于本地测试用
        String scene_info = "{\"h5_info\": {\"type\":\"Wap\",\"wap_url\": \"这里写在h5支付配置的那个域名\",\"wap_name\": \"信息认证\"}}";//我这里是网页入口，app入口参考文档的安卓和ios写法
        String tradeType = "MWEB";//H5支付标记
        String MD5 = "MD5";//虽然官方文档不是必须参数，但是不送有时候会验签失败
        JSONObject result = new JSONObject();
        String subject = request.getParameter("subject");//前端上送的支付主题
        String total_amount = request.getParameter("totalAmount");//前端上送的支付金额
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
        //金额转化为分为单位 微信支付以分为单位
        String finalmoney = StringUtils.getMoney(total_amount);
        int randomNum  = (int) (Math.random() * 1999+5000);
        String out_trade_no = TimeUtils.getSysTime("yyyyMMddHHmmss") + randomNum;
        //随机数
        String nonce_str= MD5Utils.getMessageDigest(String.valueOf(new Random().nextInt(10000)).getBytes());
        //签名数据
        StringBuilder sb = new StringBuilder();
        sb.append("appid="+APPID);
        sb.append("&body="+subject);
        sb.append("&mch_id="+MERID);
        sb.append("&nonce_str="+nonce_str);
        sb.append("&notify_url="+"这里写回调地址");
        sb.append("&out_trade_no="+out_trade_no);
        sb.append("&scene_info="+scene_info);
        sb.append("&sign_type="+"MD5");
        sb.append("&spbill_create_ip="+spbill_create_ip);
        sb.append("&total_fee="+finalmoney);
        sb.append("&trade_type="+tradeType);
        sb.append("&key="+SIGNKEY);
        System.out.println("sb="+sb);
        //签名MD5加密
        String sign = "把sb.toString()做MD5操作并且toUpperCase()一下,至于怎么MD5,百度一下或者看官方文档";
        System.out.println("sign="+sign);
        log.info("签名数据:"+sign);
        //封装xml报文
        String xml="<xml>"+
                "<appid>"+ APPID+"</appid>"+
                "<mch_id>"+ MERID+"</mch_id>"+
                "<nonce_str>"+nonce_str+"</nonce_str>"+
                "<sign>"+sign+"</sign>"+
                "<body>"+subject+"</body>"+//
                "<out_trade_no>"+out_trade_no+"</out_trade_no>"+
                "<total_fee>"+finalmoney+"</total_fee>"+//
                "<trade_type>"+tradeType+"</trade_type>"+
                "<notify_url>"+"这里写回调地址"+"</notify_url>"+
                "<sign_type>MD5</sign_type>"+
                "<scene_info>"+scene_info+"</scene_info>"+
                "<spbill_create_ip>"+spbill_create_ip+"</spbill_create_ip>"+
                "</xml>";

        String createOrderURL = "https://api.mch.weixin.qq.com/pay/unifiedorder";//微信统一下单接口
        String mweb_url = "";
        Map map = new HashMap();
        try {
            //预下单 获取接口地址
            map = WebUtils.getMwebUrl(createOrderURL, xml);
            String return_code  = (String) map.get("return_code");
            String return_msg = (String) map.get("return_msg");
            if("SUCCESS".equals(return_code) && "OK".equals(return_msg)){
                mweb_url = (String) map.get("mweb_url");//调微信支付接口地址
                System.out.println("mweb_url="+mweb_url);
            }else{
                System.out.println("统一支付接口获取预支付订单出错");
                result.put("msg", "支付错误");
                return result.toString();
            }
        } catch (Exception e) {
            System.out.println("统一支付接口获取预支付订单出错");
            result.put("msg", "支付错误");
            return result.toString();
        }
        result.put("mwebUrl",mweb_url);

        //添加微信支付记录日志等操作


        result.put("msg", "success");
        return result.toString();
    }

    /**
     * 获取用户实际ip
     * @param request
     * @return
     */
    public String getIpAddr(HttpServletRequest request){
        String ipAddress = request.getHeader("x-forwarded-for");
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){
                //根据网卡取本机配置的IP
                InetAddress inet=null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress= inet.getHostAddress();
            }
        }
        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15
            if(ipAddress.indexOf(",")>0){
                ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }
    @RequestMapping(value = "/notify")
    public void weixinPayNotify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        BufferedReader reader = request.getReader();
        String line = "";
        Map map = new HashMap();
        String xml = "<xml><return_code><![CDATA[FAIL]]></xml>";;
        JSONObject dataInfo = new JSONObject();
        StringBuffer inputString = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            inputString.append(line);
        }
        request.getReader().close();
        System.out.println("----接收到的报文---"+inputString.toString());
        if(inputString.toString().length()>0){
            map = XMLUtils.parseXmlToList(inputString.toString());
        }else{
            System.out.println("接受微信报文为空");
        }
        System.out.println("map="+map);
        if(map!=null && "SUCCESS".equals(map.get("result_code"))){
            //成功的业务。。。
            xml = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
        }else{
            //失败的业务。。。
        }
        //告诉微信端已经确认支付成功
        response.getWriter().write(xml);
    }
}
