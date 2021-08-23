package com.talk.pcCondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Worker {

    public static void main(String[] args) {
        Worker worker = new Worker();


        Customer customer = new Customer(worker);

        new Thread(customer).start();


        Producer producer = new Producer(worker);

        new Thread(producer).start();


        Producer producer1 = new Producer(worker);

        new Thread(producer1).start();


        Producer producer2 = new Producer(worker);

        new Thread(producer2).start();


    }

    private boolean f = false;// 表示是否有馒头,false 表示没有可消费的，true 表示可以消费
    ReentrantLock lock = new ReentrantLock();
    Condition conditionFull = lock.newCondition();
    Condition conditionEmpty = lock.newCondition();


    public void customer() throws Exception {
        lock.lock();

        while (!f) {
            conditionFull.await();
        }
        System.out.println(Thread.currentThread().getName() + "  消费中...........");
        double random = Math.random();
        Thread.sleep((long)(60*random));

        f = false;
        conditionEmpty.signal();

        lock.unlock();
    }

    public void produce() throws Exception {
        lock.lock();

        while (f) {
            conditionEmpty.await();
        }

        System.out.println(Thread.currentThread().getName() + "  生产中...........");
        double random = Math.random();
        Thread.sleep((long)(60*random));

        f = true;
        conditionFull.signal();

        lock.unlock();
    }
}
