package com.talk.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;

public class R1 implements Runnable {
    Servlet servlet;
    String data1 = null;

    R1(Servlet servlet,String data){
        this.servlet=servlet;
        this.data1 = data;
    }

    public void run() {
        System.out.println("线程"+Thread.currentThread().getId()+"拿到"+this.data1);
        String data2 = null;
        Exchanger exchanger = servlet.getExchanger();

        try {
            long l = (long) (Math.random() * 10000);
            System.out.println("线程"+Thread.currentThread().getId()+"等待时间："+l);
            Thread.sleep(l);

            System.out.println("线程"+Thread.currentThread().getId()+"准备交换数据");
            data2 = (String)exchanger.exchange(this.data1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("线程"+Thread.currentThread().getId()+"换到的数据："+data2);

    }
}
