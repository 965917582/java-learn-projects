package com.sdt.pojo;

public class Key {
    private static String appid = "wx1d84563a6ac34711";
    private static  String mch_id = "1491796222";
    private static  String nonce_str; //√
    private static  String sign;
    private static  String body = "goods_desc";
    private static  String spbill_create_ip; //√
    private static  String notify_url = "http://m.jnbat.com/wxPay/pay/tencentNotify_url";
    private static  String redirect_url = "http://m.jnbat.com/wxPay/success.jsp";
    private static  String trade_type="MWEB";
    private static String key = "ggy101600ggy101600ggy101600ggy10";
    private static String reqUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    private static String scene_info="{h5_info:{type:Android,app_name:王者荣耀,package_name:com.tencent.tmgp.sgame}}";

    public static String getRedirect_url() {
        return redirect_url;
    }

    public static void setRedirect_url(String redirect_url) {
        Key.redirect_url = redirect_url;
    }

    public static String getKey() {
        return key;
    }

    public static void setKey(String key) {
        Key.key = key;
    }

    public static String getReqUrl() {
        return reqUrl;
    }

    public static void setReqUrl(String reqUrl) {
        Key.reqUrl = reqUrl;
    }

    public static String getAppid() {
        return appid;
    }

    public static void setAppid(String appid) {
        Key.appid = appid;
    }

    public static String getMch_id() {
        return mch_id;
    }

    public static void setMch_id(String mch_id) {
        Key.mch_id = mch_id;
    }

    public static String getNonce_str() {
        return nonce_str;
    }

    public static void setNonce_str(String nonce_str) {
        Key.nonce_str = nonce_str;
    }

    public static String getSign() {
        return sign;
    }

    public static void setSign(String sign) {
        Key.sign = sign;
    }

    public static String getBody() {
        return body;
    }

    public static void setBody(String body) {
        Key.body = body;
    }

    public static String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    public static void setSpbill_create_ip(String spbill_create_ip) {
        Key.spbill_create_ip = spbill_create_ip;
    }

    public static String getNotify_url() {
        return notify_url;
    }

    public static void setNotify_url(String notify_url) {
        Key.notify_url = notify_url;
    }

    public static String getTrade_type() {
        return trade_type;
    }

    public static void setTrade_type(String trade_type) {
        Key.trade_type = trade_type;
    }
}
