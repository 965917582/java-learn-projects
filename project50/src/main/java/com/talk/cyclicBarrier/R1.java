package com.talk.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class R1 implements Runnable {
    Servlet servlet;

    R1(Servlet servlet){
        this.servlet=servlet;
    }

    public void run() {
        CyclicBarrier cb = servlet.getCyclicBarrier();
        try {
            long l = (long) (Math.random() * 10000);
            System.out.println("线程"+Thread.currentThread().getId()+"执行时间："+l);
            Thread.sleep(l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("线程"+Thread.currentThread().getId()+"到达集合地点");
        try {
            cb.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println("线程"+Thread.currentThread().getId()+"继续执行");

    }
}
