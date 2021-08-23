package com.talk.readWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Servlet2 {

    private Object data=null;//共享数据
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    //读
    public void read(){
        rwl.readLock().lock();
        System.out.println(Thread.currentThread().getName()+"准备读");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程"+Thread.currentThread().getId()+"读取："+this.data);

        rwl.readLock().unlock();

    }

    //写
    public void write(){
        long data = (long) (Math.random() * 1000);
        rwl.writeLock().lock();
        System.out.println(Thread.currentThread().getName()+"准备写");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.data = data;
        System.out.println("线程"+Thread.currentThread().getId()+"写入：" + data);
        rwl.writeLock().unlock();

    }


}
