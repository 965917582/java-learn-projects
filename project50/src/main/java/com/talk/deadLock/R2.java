package com.talk.deadLock;

public class R2 implements Runnable {

    Test test;

    R2(Test test){
        this.test = test;
    }

    public void run() {
        try {
            test.m2();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
