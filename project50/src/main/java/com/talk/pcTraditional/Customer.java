package com.talk.pcTraditional;

public class Customer implements Runnable {

    Worker worker;

    public Customer(Worker pc) {
        this.worker = pc;
    }

    public void run() {
        try {
            while (true) {
                worker.customer();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
