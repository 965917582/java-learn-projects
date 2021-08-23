package com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

    public static void main(String[] args) {
        //线程池，一开始就创建3个线程
        //ExecutorService threadPool = Executors.newFixedThreadPool(3);
        ExecutorService threadPool = Executors.newCachedThreadPool();
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();

        //往池子里扔10个任务，每个任务是Runnable
        for(int i=1;i<=10;i++){
            final int task = i;
            threadPool.execute(new Runnable() {
                public void run() {
                    for (int j=1;j<=10;j++){
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+"正在第"+j+"次循环,第"+task+"个任务");
                    }
                }
            });
        }

        threadPool.shutdown();

    }


}
