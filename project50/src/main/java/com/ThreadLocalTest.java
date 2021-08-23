package com;

import java.util.Random;

public class ThreadLocalTest {

    private static ThreadLocal<MyThreadScopeData> myThreadScopeDataThreadLocal = new ThreadLocal<MyThreadScopeData>();

    public static void main(String[] args) {
        for(int i=0;i<2;i++){
            new Thread(new Runnable() {
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName()
                            +"has put data :"+data );

                    MyThreadScopeData.getThreadInstance().setName("name"+data);
                    MyThreadScopeData.getThreadInstance().setAge(data);
                    new ThreadLocalTest.A().get();
                    new ThreadLocalTest.B().get();

                }
            }).start();
        }

    }

    static class A{
        public void get(){
            MyThreadScopeData myData = MyThreadScopeData.getThreadInstance();
            System.out.println("A from "+Thread.currentThread().getName()+":" +myData.getName()+","+myData.getAge());

        }
    }

    static class B{
        public void get(){
            MyThreadScopeData myData = MyThreadScopeData.getThreadInstance();
            System.out.println("B from "+Thread.currentThread().getName()+":" +myData.getName()+","+myData.getAge());

        }
    }

}

//单例模式
class MyThreadScopeData{
    private MyThreadScopeData(){}

    //这时不用加synchronized，不存在两线程去搞同一份数据的问题
    public static MyThreadScopeData getThreadInstance(){
        MyThreadScopeData instance = map.get();
        if(instance == null){
            instance = new MyThreadScopeData();
            map.set(instance);
        }
        return instance;
    }

    private static ThreadLocal<MyThreadScopeData> map = new ThreadLocal<MyThreadScopeData>();

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}