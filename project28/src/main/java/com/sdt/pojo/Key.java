package com.sdt.pojo;

public class Key {
    //支付宝提供的公钥
    private static String aliPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjSq0raU9/yC/SVjl8j+ZYW5zC2m4Oj3Q58rUWLK5Uq8v2bhwACX5Dj29whM5kFcrPJzQi8mbL0r7+sv+eKM2rgjYUiEBP/CdV5UruJBawMup37E6DKxXNKhi60KTiY3g6ngGeoY/4KRjd88ALgOULwysxCdJl0Fmsm+2pdD1MqktZSHRksuImofvNEv/f3kLxhfFLr8SkOYAJXrDu9tqRDfe/XCurCuXln2EtCm8meQc2E+OvW3XHqV11IRPhUvH3hEs2CeeLebDlPOcbjVPaYzFxeTX3PZqQxlUYOjK8mj7UsX44/TEjyNehB0TULoMYKVCs5yLM7QM6k8NalQ/mQIDAQAB";

    private static String privateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQChXL8it13Y/fM6JU3IiZ2V98iKQjhL1ZfEY5LUR/+Wo8HaRZUxBzqkfpsf6caN+N/sn04VwJuIzv5aFYi8rlbngl9284YNkopxLY07UH5WBQIPSRR5y++Sdwth21KqMXIKfWykzUwUodjKewRbEfqr+KI93YKJEj9ItwxH7rqX54RTeZPaHh1XGUMhwYtNhmbrSoCQJ2tkrOc4qhP+u0FDLbg+w9Fg1uGSy8MYZwGpBLfvAM1Og6X+/E0fJEoSjmCbwy0d/+64B+SoQfntKbBYVAGODORhRwAMgfDYouAPRO2aF42ldEuVyADLWGmRye/Jliitz0FFspFM9RPKkp+nAgMBAAECggEAZwB3GcgG5f6lBhbN4hbGOvaiUm8W1IGRkVEmZs9WvWfm1FfadiNxMZOHngVyMyoMdlTyWTxLjDblcceRMy/uVXWJTrsAdSV3resv3g7xtiMYP32czmp5kPrgjySbTfymGUAa29AYoor1gbqo+yEs7B2YIvmE286ECvydoEUpYtDmTGL8wO7F0wlICXRO6up7MZOJtv4Ngan7aO9HV7snsIchakBJaImuXDkawEzGxxuw5rorE3QaAunt8neore8nv9Bf+sHMqOgk4OBzFKQ7pZII3JHZDvsYHgkBe7TgrujxwXpqGNl1VQwh2UFaBls5myZIeqb0Mub+dreq5ZzPUQKBgQDppNETS6oXtbLXaozlmkA2orc/wYCuuEiyuzZ6EeDMmmukC8oE3DM+cd38RjtwKBra2CtVbrs+Im165WsZrZXeP2SIjI1mPj1fOou9BMqPE29edk5XRSKY49xmvv2dkQreqOx+eBBuHyRXSfAofkGtT3XQ3p7x5wChauDiwlb8qwKBgQCwzV6uxVXJk1r4iyfqpX81b4oKqMkmS+EFwaqspPvYyYQ5X06EruryjzEe/kgp+dF4t0EPqaSoyE2O8jO0g+lcBdcccNUME2VeUbangFuaeL0jwY3UpBQCKCmWW/DxQL24RrRYVVpH7RPytbVv0Xi3cQJSySJKldxJjxYgrFhw9QKBgG1sMDLOO/Hwubpjf2tEq5Aq8pGcaUzqp7l1LlVLLDIGnCTvFITkL+et4l308n9beQBHPzw6qNy3uPhWm6sh/c9hdw7wbISW351KyQkURl1tp7ngxF3g1gwuoxlHl3WE6UdQa7nrNx6r3RQ4X45HWzD0xuO0b1Ixcr0mVf49MAoTAoGAZhBYjVn72R8I0Bw9EdcyJV3beaXQYRxCrbkMVxfzD0Xd3+TmBfCYTyhcegDfFeRSiXZ4x5ruJEVliJTHRnk0GNyCPrfgNVVpGlbfs7iEqRr0TRTqVIvXxRr8TwGKiSsPmrauW6QCNy1ka6N8Ny3cm0FQzwuvkREMFybT5k63y5UCgYAnKm5E9OtZXyjYpdu9xWx3zuDMay+2GTVB1MMUrHPYVVyOVd0Jm2hfKHJNwWZDF8/rtQhPbHwkDriBF1+CY9/eHCYWR7FKoeHDj8s7LnoQFVkr8+lwproiGMA3hCH5GP5uuZ8nk/ToOrAM8ai7y5HzdbBZnElZu9T07evKE3Xfkw==";

    private static  String app_id = "2021000117628066";

    private static  String method = "alipay.trade.page.pay";

    private static  String return_url = "http://aijia.free.idcfengye.com/project28/toPaidPage";

    private static  String notify_url = "http://aijia.free.idcfengye.com/project28/handleOrder";

    private static  String charset = "utf-8";

    private static  String sign_type = "RSA2";

    private static  String version = "1.0";

    private static  String timestamp ;

    private static  String biz_content ;

    public static String getAliPublicKey() {
        return aliPublicKey;
    }

    public static void setAliPublicKey(String aliPublicKey) {
        Key.aliPublicKey = aliPublicKey;
    }

    public static String getPrivateKey() {
        return privateKey;
    }

    public static void setPrivateKey(String privateKey) {
        Key.privateKey = privateKey;
    }

    public static String getApp_id() {
        return app_id;
    }

    public static void setApp_id(String app_id) {
        Key.app_id = app_id;
    }

    public static String getMethod() {
        return method;
    }

    public static void setMethod(String method) {
        Key.method = method;
    }

    public static String getReturn_url() {
        return return_url;
    }

    public static void setReturn_url(String return_url) {
        Key.return_url = return_url;
    }

    public static String getNotify_url() {
        return notify_url;
    }

    public static void setNotify_url(String notify_url) {
        Key.notify_url = notify_url;
    }

    public static String getCharset() {
        return charset;
    }

    public static void setCharset(String charset) {
        Key.charset = charset;
    }

    public static String getSign_type() {
        return sign_type;
    }

    public static void setSign_type(String sign_type) {
        Key.sign_type = sign_type;
    }

    public static String getTimestamp() {
        return timestamp;
    }

    public static void setTimestamp(String timestamp) {
        Key.timestamp = timestamp;
    }

    public static String getVersion() {
        return version;
    }

    public static void setVersion(String version) {
        Key.version = version;
    }

    public static String getBiz_content() {
        return biz_content;
    }

    public static void setBiz_content(String biz_content) {
        Key.biz_content = biz_content;
    }
}
