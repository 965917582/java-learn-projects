package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContext {

    public static ApplicationContext context;

    static{
        context = new ClassPathXmlApplicationContext("/spring.xml");
    }


    public static Object getBean(String name){
        return context.getBean(name);
    }




}
