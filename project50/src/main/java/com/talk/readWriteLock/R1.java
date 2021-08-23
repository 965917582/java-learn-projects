package com.talk.readWriteLock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读
 */
public class R1 implements Runnable {
    Servlet servlet;

    R1(Servlet servlet){
        this.servlet=servlet;
    }

    public void run() {
        ReentrantReadWriteLock rwl = servlet.getRwl();

        while(true){
            rwl.readLock().lock();
            System.out.println(Thread.currentThread().getName()+"准备读");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object data = servlet.getData();
            System.out.println("线程"+Thread.currentThread().getId()+"读取："+data);

            rwl.readLock().unlock();
        }


    }
}
