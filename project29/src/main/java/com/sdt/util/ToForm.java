package com.sdt.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ToForm {

    public static String from(String reqUrl, Map<String, String> hiddens) {
        StringBuffer sf=new StringBuffer();
        sf.append("<form action=\"" + reqUrl + "\" method=\"post\">"+"\r\n");
        if (null != hiddens && 0 != hiddens.size()) {
            Set<Map.Entry<String, String>> set = hiddens.entrySet();
            Iterator<Map.Entry<String, String>> it = set.iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> ey = it.next();
                String key = ey.getKey();
                String value = ey.getValue();
                sf.append("<input type='hidden' name='" + key + "' value='" + value + "'/>"+"\r\n");
            }
        }
        sf.append("<input type='submit' value='" + "支付" + "'/>"+"\r\n");
        sf.append("<script type='text/javascript'>document.forms[0].submit()</script>");//自动提交
        sf.append("</form>");


    /* String from="<form"+" "+"name=punchout_form"+" "+ "action= "+"https://openapi.alipaydev.com/gateway.do"+" "+"method=post>"
        +"<input"+" "+" type="+" "+"hidden"+"+ "+"name="+"app_id"+"+ "+"\" value=\""+map.get("app_id")+"\"/>"
        +"<input"+" "+" type="+"text"+"+ "+"name="+"biz_content"+"+ "+" \" value=\""+map.get("biz_content")+"\"/>"
        +"<input"+"+ "+" type="+"hidden"+"+ "+"name="+"charset"+"+ "+" \" value=\""+map.get("charset")+"\"/>"
        +"<input "+"+ "+" type="+"hidden"+"+ "+"name="+"format"+"+ "+" \" value=\""+map.get("format")+"\"/>"
        +"<input "+"+ "+"type="+"hidden"+"+ "+"name="+"method"+"+ "+" \" value=\""+map.get("method")+"\"/>"
        +"<input "+"+ "+"type="+"hidden"+"+ "+"name="+"notify_url"+"+ "+"+ "+" \" value=\""+map.get("notify_url")+"\"/>"
        +"<input "+"+ "+"type="+"hidden"+"+ "+"name="+"return_url"+"+ "+" \" value=\""+map.get("return_url")+"\"/>"
        +"<input "+"+ "+"type="+"hidden"+"+ "+"name="+"sign"+"+ "+" \" value=\""+map.get("sign")+"\"/>"
        +"<input "+"+ "+"type="+"hidden"+"+ "+"name="+"sign_type"+"+ "+" \" value=\""+map.get("sign_type")+"\"/>"
        +"<input "+"+ "+"type="+"hidden"+"+ "+"name="+"timestamp"+"+ "+" \" value=\""+map.get("timestamp")+"\"/>"
        +"<input "+"+ "+"type="+"hidden"+"+ "+"name="+"version"+"+ "+" \" value=\""+map.get("version")+"\"/>"
        +"<input "+"+ "+"type="+"submit"+"+ "+" \" value=\""+"提交"+"\"/>"
        +"</form>";*/
        return sf.toString();
    }
}
