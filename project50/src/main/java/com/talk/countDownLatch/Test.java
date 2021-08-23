package com.talk.countDownLatch;


public class Test {

    public static void main(String[] args) {
        Servlet s = new Servlet();

        new Thread(new R1(s)).start();
        new Thread(new R2(s)).start();



    }

}
