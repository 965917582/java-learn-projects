package com;

public class TraditionalThread {
    public static void main(String[] args) {

        Thread thread = new Thread(){
            @Override
            public void run() {
                while(true){
                    System.out.println("嗨"+Thread.currentThread().getName());
                    //System.out.println(this.getName());

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();


        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                while(true){
                    System.out.println("哈"+Thread.currentThread().getName());

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread2.run();



    }

}
