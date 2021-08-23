package com.talk.semaphore;

import java.util.concurrent.Semaphore;

public class R1 implements Runnable {
    Servlet servlet;

    R1(Servlet servlet){
        this.servlet=servlet;
    }

    public void run() {
        Semaphore sp = servlet.getSemaphore();
        try {
            sp.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("线程"+Thread.currentThread().getId()+"获得信号灯，开始执行"/*+sp.availablePermits()*/);
        try {
            long l = (long) (Math.random() * 10000);
            System.out.println("线程"+Thread.currentThread().getId()+"执行时间："+l);
            Thread.sleep(l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程"+Thread.currentThread().getId()+"执行结束");

        sp.release();
    }
}
