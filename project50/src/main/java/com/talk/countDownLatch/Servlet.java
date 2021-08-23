package com.talk.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class Servlet {
    CountDownLatch cdl = new CountDownLatch(3);

    public CountDownLatch getCountDownLatch(){
        return this.cdl;
    }

}
