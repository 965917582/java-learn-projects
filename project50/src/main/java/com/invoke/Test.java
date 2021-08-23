package com.invoke;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws Exception {
        //1.加载字节码对象
        Class<?> aClass=null;
        aClass = Class.forName("com.invoke.Person");

        //2.获取全部的构造方法对象
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();

        //3.获取所有的成员变量对象，并用for循环打印出所有变量的修饰符对应的数字
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getModifiers());
        }

        //4.获取account成员变量对象
        Field account = aClass.getDeclaredField("account");

        //5.获取所有的成员方法对象
        Method[] declaredMethods = aClass.getDeclaredMethods();

        //6.获取howold方法对象，并获取howold方法的返回值
        Method howold = aClass.getMethod("howold", int.class);
        Object invoke = howold.invoke(new Person(),3);
        System.out.println(invoke);

        //7.调用introduction方法。
        Method introduction = aClass.getMethod("introduction", Person.class);
        introduction.invoke(new Person(),new Person(4,"张三",18));


    }




}
