package com.talk.deadLock;

public class Test {
    Object lock1 = new Object();
    Object lock2 = new Object();


    public static void main(String[] args) throws Exception {
        Test test = new Test();
        new Thread(new R1(test)).start();
        new Thread(new R2(test)).start();

    }


    public void m1() throws Exception {
        synchronized (lock1){
            System.out.println("m1获得condition1");
            Thread.sleep(5000);
            synchronized (lock2){
                System.out.println("m1获得condition2");
            }
        }

    }

    public void m2()throws Exception {
        synchronized (lock2){
            System.out.println("m2获得condition2");
            Thread.sleep(5000);
            synchronized (lock1){
                System.out.println("m2获得condition1");
            }
        }
    }


}
