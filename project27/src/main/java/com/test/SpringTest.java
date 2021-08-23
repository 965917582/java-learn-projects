package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    public static ApplicationContext context;

    static{
        context = new ClassPathXmlApplicationContext("/spring/springtest.xml");
    }

    public static void main(String[] args) {
        Object bean = context.getBean("jedis");

    }

    public static Object getBean(String name){
        return context.getBean(name);
    }


}
