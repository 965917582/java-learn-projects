package com.talk.deadLock;

public class R1 implements Runnable {

    Test test;

    R1(Test test){
        this.test = test;
    }

    public void run() {
        try {
            test.m1();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
