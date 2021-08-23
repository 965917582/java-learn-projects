package com.talk.readWriteLock;


public class Test {

    public static void main(String[] args) {
        /*Servlet s = new Servlet();

        new Thread(new R1(s)).start();
        new Thread(new R1(s)).start();

        new Thread(new R2(s)).start();
        new Thread(new R2(s)).start();
        new Thread(new R2(s)).start();*/

        final Servlet2 s2 = new Servlet2();

        new Thread(new Runnable() {
            public void run() {
                while(true) {
                    s2.read();
                }
            }
        }).start();


        new Thread(new Runnable() {
            public void run() {
                while(true) {
                    s2.write();
                }
            }
        }).start();


    }

}
