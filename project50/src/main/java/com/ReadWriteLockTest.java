package com;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {

    public static void main(String[] args) {
        final Queue3 q3 = new Queue3();

        for(int i=0;i<3;i++){
            new Thread(){
                public void run(){
                    while(true){
                        q3.get();
                    }
                }
            }.start();

            new Thread(){
                public void run(){
                    while(true){
                        q3.put(new Random().nextInt(10000));
                    }
                }
            }.start();
        }

    }


}

class Queue3{
    private Object data=null;//共享数据，只能有一个线程能
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public void get(){
        rwl.readLock().lock();

        try{
            System.out.println(Thread.currentThread().getName()+"准备读");
            Thread.sleep((long)(Math.random()*1000));
            System.out.println(Thread.currentThread().getName()+"读数据："+data);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwl.readLock().unlock();
        }

    }

    public void put(Object data){
        rwl.writeLock().lock();

        try{
            System.out.println(Thread.currentThread().getName()+"准备写");
            Thread.sleep((long)(Math.random()*1000));
            System.out.println(Thread.currentThread().getName()+"写数据"+data);
            this.data=data;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwl.writeLock().unlock();
        }
    }
}




















