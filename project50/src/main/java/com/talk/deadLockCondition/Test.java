package com.talk.deadLockCondition;


import java.util.concurrent.locks.ReentrantLock;

public class Test {

    public static void main(String[] args) throws Exception {
        ReentrantLock lock1 = new ReentrantLock();
        ReentrantLock lock2 = new ReentrantLock();


        new Thread(new R1(lock1,lock2)).start();
        new Thread(new R2(lock1,lock2)).start();



    }



}
