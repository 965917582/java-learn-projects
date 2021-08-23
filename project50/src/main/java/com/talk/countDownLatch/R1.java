package com.talk.countDownLatch;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class R1 implements Runnable {
    Servlet servlet;

    R1(Servlet servlet){
        this.servlet=servlet;
    }

    public void run() {
        CountDownLatch cdl = servlet.getCountDownLatch();

        System.out.println("线程"+Thread.currentThread().getId()+"等待倒计时");
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("线程"+Thread.currentThread().getId()+"继续执行");

    }
}
