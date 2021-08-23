package com;

import java.util.concurrent.*;

public class CallableAndFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future<String> future =
        threadPool.submit(
                new Callable<String>() {
                    public String call() throws Exception {
                        Thread.sleep(2000);
                        return "hello";
                    }
                }
        );

        System.out.println("等待结果" );

        System.out.println("拿到结果："+future.get());






    }

}
