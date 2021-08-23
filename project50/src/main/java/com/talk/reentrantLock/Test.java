package com.talk.reentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  两个线程实现通信,交替运行
 */
public class Test {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(new R(lock,condition)).start();
        new Thread(new R(lock,condition)).start();


    }

}
