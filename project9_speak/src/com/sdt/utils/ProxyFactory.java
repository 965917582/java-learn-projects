package com.sdt.utils;

import com.sdt.service.IAccountService;

import java.lang.reflect.Proxy;

public class ProxyFactory {
    
    public static Object getProxy(String s)  {
        try{
            Class<?> c = Class.forName(s);
            Object o = c.newInstance();
            ProxyHandler proxyHandler = new ProxyHandler(o);
            Object proxyInstance = Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), proxyHandler);
            return proxyInstance;
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
