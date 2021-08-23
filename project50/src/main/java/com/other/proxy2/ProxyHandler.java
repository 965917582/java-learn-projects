package com.other.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler  implements InvocationHandler {


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //原业务
        method.invoke(args);

        //新增
        System.out.println("日志");

        return null;
    }
}
