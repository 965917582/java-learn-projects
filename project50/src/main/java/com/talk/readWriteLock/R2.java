package com.talk.readWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 写
 */
public class R2 implements Runnable {
    Servlet servlet;

    R2(Servlet servlet){
        this.servlet=servlet;
    }

    public void run() {
        ReentrantReadWriteLock rwl = servlet.getRwl();

        while(true) {
            long data = (long) (Math.random() * 1000);
            rwl.writeLock().lock();
            System.out.println(Thread.currentThread().getName()+"准备写");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            servlet.setData(data);
            System.out.println("线程"+Thread.currentThread().getId()+"写入：" + data);
            rwl.writeLock().unlock();
        }
    }
}
