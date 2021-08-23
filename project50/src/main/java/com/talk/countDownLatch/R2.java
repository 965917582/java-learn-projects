package com.talk.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class R2 implements Runnable {
    Servlet servlet;

    R2(Servlet servlet){
        this.servlet=servlet;
    }
    public void run() {
        System.out.println("线程"+Thread.currentThread().getId()+"开启倒计时");
        CountDownLatch cdl = servlet.getCountDownLatch();
        System.out.println("countDown");
        cdl.countDown();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("countDown");
        cdl.countDown();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("countDown");
        cdl.countDown();
    }
}
