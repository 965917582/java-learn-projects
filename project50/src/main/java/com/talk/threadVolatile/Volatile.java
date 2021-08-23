package com.talk.threadVolatile;

public class Volatile {

    int m = 0;
    int n = 1;

    public void set(){
        m = 6;
        n = m;
    }

    public void print(){
        System.out.println("m:"+m+",n:"+n);
    }

    public static void main(String[] args) {
        while(true){
            final Volatile v = new Volatile();
            new Thread(new Runnable(){
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    v.set();
                }

            }).start();

            new Thread(new Runnable(){
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    v.print();
                }

            }).start();
        }
    }
}
