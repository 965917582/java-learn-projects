package com.talk.deadLockCondition;

import java.util.concurrent.locks.ReentrantLock;

public class R2 implements Runnable {

    ReentrantLock lock1;
    ReentrantLock lock2;

    R2(ReentrantLock lock1, ReentrantLock lock2){
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    public void run() {
        lock2.lock();

        System.out.println(Thread.currentThread().getId()+"获得condition1");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock1.lock();
        System.out.println(Thread.currentThread().getId()+"获得condition2");
        lock1.unlock();

        lock2.unlock();

    }


}
