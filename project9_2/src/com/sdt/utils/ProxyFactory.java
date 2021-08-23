package com.sdt.utils;

import java.lang.reflect.Proxy;

public class ProxyFactory {
    public static Object getProxy(String s){
        Class<?> c=null;
        Object instance=null ;
        try {
            c = Class.forName(s);
            instance = c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ProxyHandler proxyHandler = new ProxyHandler(instance);
        Object proxyInstance = (Object) Proxy.newProxyInstance(instance.getClass().getClassLoader(), instance.getClass().getInterfaces(), proxyHandler);

        return proxyInstance;
    }
}
