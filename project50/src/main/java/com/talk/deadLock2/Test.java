package com.talk.deadLock2;


public class Test {

    public static void main(String[] args) throws Exception {
        Object lock1="2";
        Object lock2="1";

        new Thread(new R1(lock1,lock2)).start();
        new Thread(new R2(lock1,lock2)).start();



    }



}
