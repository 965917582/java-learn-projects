package com.sdt.controller;

import com.sdt.anno.MyMapping;
import com.sdt.domain.Handler;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class MyDispatherServlet extends HttpServlet {
    HashMap<String, Object> map = new HashMap<>();

    @Override
    public void init() throws ServletException {
        //获取spring容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springmvc.xml");
        //获取容器内所有bean对象
        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            //判断是否是控制器controller
            Object bean = context.getBean(beanName);
            if(bean.getClass().isAnnotationPresent(Controller.class)){
                //获取控制器的@RequestMapping的value值
                String[] class_url = bean.getClass().getAnnotation(RequestMapping.class).value();

                //获取控制器所有方法
                Method[] methods = bean.getClass().getDeclaredMethods();
                for (Method method : methods) {
                    //判断方法是否打了我们的注解
                    if(method.isAnnotationPresent(MyMapping.class)){
                        Handler handler = new Handler();
                        handler.setObj(bean);
                        handler.setMethod(method);

                        String contextPath = getServletContext().getContextPath();
                        String method_url = method.getAnnotation(MyMapping.class).value();
                        map.put(contextPath+class_url[0]+method_url,handler);
                    }
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("dopost");
        String requestURI = req.getRequestURI();
        Handler handler = (Handler) map.get(requestURI);
        //判断是否存在对应请求路径
        if(handler!=null){
            //调用对应方法
            try{
                handler.getMethod().invoke(handler.getObj(),handler.getArgs());
            }catch(Exception e){
                e.printStackTrace();
            }
        }


    }
}
