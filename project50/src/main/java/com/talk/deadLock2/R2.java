package com.talk.deadLock2;

public class R2 implements Runnable {

    Object lock1;
    Object lock2;

    R2(Object lock1, Object lock2){
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    public void run() {
        synchronized (lock2){
            System.out.println(Thread.currentThread().getId()+"获得condition2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock1){
                System.out.println(Thread.currentThread().getId()+"获得condition1");
            }
        }

    }


}
