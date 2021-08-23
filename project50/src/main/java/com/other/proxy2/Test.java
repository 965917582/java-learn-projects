package com.other.proxy2;

import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {

        A a  = new A();

        interface1 proxy = (interface1)Proxy.newProxyInstance(A.class.getClassLoader(), a.getClass().getInterfaces(), new ProxyHandler());

        proxy.method1();

        proxy.method2();


    }


}
