package com.talk.pcTraditional;

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

    public synchronized void customer() throws Exception {
        while (!f) {
            this.wait();
        }
        System.out.println(Thread.currentThread().getName() + "  消费中...........");
        double random = Math.random();
        Thread.sleep((long)(60*random));

        f = false;
        this.notifyAll();

    }

    public synchronized void produce() throws Exception {
        while (f) {
            this.wait();
        }

        System.out.println(Thread.currentThread().getName() + "  生产中...........");
        double random = Math.random();
        Thread.sleep((long)(60*random));

        f = true;
        this.notifyAll();
    }
}
