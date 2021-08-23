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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class MyDispatherServlet extends HttpServlet {
    //容器，  路径：
    HashMap<String, Object> map = new HashMap<>();

    @Override
    public void init() throws ServletException {
        //获取spring容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springmvc.xml");
        //获取所有bean对象，筛选出控制器对象
        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            Object bean = context.getBean(beanName);
            if(bean.getClass().isAnnotationPresent(Controller.class)){
                //获取requestmapping注解值
                String[] class_url = bean.getClass().getAnnotation(RequestMapping.class).value();
                //获取控制器中有我们的注解的方法，将它存入容器
                Method[] methods = bean.getClass().getDeclaredMethods();
                for (Method method : methods) {
                    if(method.isAnnotationPresent(MyMapping.class)){
                        Handler handler = new Handler();
                        handler.setObj(bean);//控制器对象
                        handler.setMethod(method);//方法对象
                        String method_url = method.getAnnotation(MyMapping.class).value();
                        map.put(getServletContext().getContextPath()+class_url[0]+method_url,handler);

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
        //获取请求uri，反射调用控制器方法
        String requestURI = req.getRequestURI();
        Handler h = (Handler) map.get(requestURI);
        if(h!=null){
            try {
                h.getMethod().invoke(h.getObj(),null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

    }
}
