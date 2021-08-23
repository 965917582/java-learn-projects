package com.talk.synchronize;

public class R implements Runnable {


    public void run() {
        for(int i=0;i<10;i++ ){

            synchronized (R.class){


                for(int j=0;j<10;j++){
                    System.out.println(Thread.currentThread().getId()+"-"+j);
                }
            }
        }

    }
}
