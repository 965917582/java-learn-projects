package com.talk.reentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class R implements Runnable{

    ReentrantLock lock = null;
    Condition condition = null;
    boolean flag =false;

    R(ReentrantLock lock, Condition condition  ){
        this.lock = lock;
        this.condition=condition;
    }

    public void run() {

        for(int i=0;i<10;i++) {
            lock.lock();

            try {

                condition.await();
                for (int j = 0; j < 5; j++) {
                    System.out.println(Thread.currentThread().getId() +"-"+ j);
                }
                condition.signal();


            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }

    }
}
