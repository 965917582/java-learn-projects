package com.talk;

public class R1 implements Runnable{

    Servlet servlet;

    public R1(Servlet servlet){
        this.servlet=servlet;
    }

    public void run() {
        while (true){
            try {
                servlet.doGet();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
