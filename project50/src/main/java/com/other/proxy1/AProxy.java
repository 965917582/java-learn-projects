package com.other.proxy1;

public class AProxy implements interface1 {

    A a;

    public void method1() {
        //日志
        System.out.println("日志");
        //原业务
        a.method1();

    }

    public void method2() {

    }


}
