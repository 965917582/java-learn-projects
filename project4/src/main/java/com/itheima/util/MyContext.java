package com.itheima.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyContext {
    //容器
    Map<String,Object> map = new ConcurrentHashMap();
    Map<Class,Object> map2 = new ConcurrentHashMap();
    //构造函数，解析配置文件，创建对象放入容器，并依赖注入
    public MyContext(String xmlPath) {
        //读配置文件
        SAXReader saxReader = new SAXReader();
        InputStream is = MyContext.class.getResourceAsStream(xmlPath);
        Document document = null;
        try{
            document = saxReader.read(is);
        }catch(Exception e){
            e.printStackTrace();
        }

        //1.创建对象放入容器
        //获取根标签下bean标签，获取它class属性，反射创建对象，获取id属性，一起存入容器
        List<Element> elements = document.getRootElement().elements();
        for (Element element : elements) {
            if("bean".equals(element.getName())){
                String id = element.attributeValue("id");
                String className = element.attributeValue("class");
                try{
                    Class c = Class.forName(className);
                    Object o = c.newInstance();
                    map.put(id,o);
                    map2.put(c,o);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        //2.依赖注入
        //遍历bean，有property子标签的，用set方法注入
        for (Element element : elements) {
            if("bean".equals(element.getName())){
                List<Element> beanElements = element.elements();
                for (Element beanElement : beanElements) {
                    if("property".equals(beanElement.getName())){
                        String name = beanElement.attributeValue("name");
                        String ref = beanElement.attributeValue("ref");
                        //拼接set方法名
                        String setMethodName = "set"+name.substring(0,1).toUpperCase()+name.substring(1);
                        //用反射注入
                        try{
                            Object obj = map.get(element.attributeValue("id"));//被注入对象
                            Object param = map.get(ref);//参数对象
                            Method method = obj.getClass().getMethod(setMethodName, param.getClass().getInterfaces());//方法对象
                            method.invoke(obj,param);
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    //getBean(String)
    public Object getBean(String beanId){
        return map.get(beanId);
    }

    //getBean(Class)
    /*public <T> T getBean(Class<T> c){
        T t = (T) map2.get(c);
        return t;
    }*/

    public Object getBean(Class c){
        return map2.get(c);
    }
}
