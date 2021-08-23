package com;

import com.service.Service1;

public class Test {

    public static void main(String[] args) {
        Service1 bean = (Service1) SpringContext.getBean("servlet1");
        bean.method1();

    }
}
