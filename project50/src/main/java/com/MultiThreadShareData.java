package com;

public class MultiThreadShareData {
    public static void main(String[] args) {
        final ShareData1 data1 = new ShareData1();

        new Thread(new Runnable() {
            public void run() {
                data1.decrement();
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                data1.increment();
            }
        }).start();

    }



}

class ShareData1 implements Runnable {
    private int count = 100;
    public void run() {
        while(true){
            count--;
        }
    }

    private int j = 0;
    public synchronized void increment(){
        j++;
    }
    public synchronized void decrement(){
        j--;
    }
}
