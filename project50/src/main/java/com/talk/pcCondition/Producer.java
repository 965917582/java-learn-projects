package com.talk.pcCondition;

public class Producer implements Runnable {

    Worker worker;

    public Producer(Worker pc) {
        this.worker = pc;
    }

    public void run() {
        try {
            while(true) {
                worker.produce();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
