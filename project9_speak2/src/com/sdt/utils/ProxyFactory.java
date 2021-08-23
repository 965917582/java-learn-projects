package com.sdt.utils;

import com.sdt.service.IAccountService;

import java.lang.reflect.Proxy;

public class ProxyFactory {

    public static Object getProxy (String s){
        Object o=null;
        try{
            Class<?> c = Class.forName(s);
            o = c.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        ProxyHandler proxyHandler = new ProxyHandler(o);
        Object proxyInstance = Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), proxyHandler);
        return proxyInstance;
    }

    public static Object getProxy (Class c){
        Object o=null;
        try{
            o = c.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        ProxyHandler proxyHandler = new ProxyHandler(o);
        Object proxyInstance = Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), proxyHandler);
        return proxyInstance;
    }
}
