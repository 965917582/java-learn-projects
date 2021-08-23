package com;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    public static void main(String[] args) {
        new LockTest().init();
    }

    private void init(){
        final Outputer outputer = new Outputer();
        new Thread(new Runnable() {
            public void run() {
                while(true){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outputer.output("zengaijia");
                }
            }
        }).start();


        new Thread(new Runnable() {
            public void run() {
                while(true){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outputer.output("zhuyixin");
                }
            }
        }).start();
    }

    class Outputer{
        Lock lock = new ReentrantLock();

        public void output(String name){
            int len = name.length();
            lock.lock();
            //如果锁上后内部出现异常，就会跳出方法，锁还没有释放，就像晕倒在里面了
            //所以捕捉起来,在finally无论如何也释放锁
            try{
                for(int i=0;i<len;i++){
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }

    }

}
