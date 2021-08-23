package com;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 子线程走10下，主线程走10下，交替50次
 */
public class ConditionCommunication {

    public static void main(String[] args) {

        final Business business = new Business();
        new Thread(new Runnable() {
            public void run() {
                for (int i=0;i<=50;i++){
                    business.sub(i);
                }
            }
        }).start();

        for (int i=0;i<=50;i++){
            business.main(i);
        }
    }

    //静态方法里不能创建内部类的实例对象，加static会类似外部类可以在静态方法实例化
    static class Business{
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        boolean bShouldSub=false;

        public void sub(int i){
            lock.lock();
            try{
                while(!bShouldSub){
                    try{
                        condition.await();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

                for (int j=0;j<=10;j++){
                    System.out.println("sub thread "+i+"-"+j);
                }
                bShouldSub=false;
                condition.signal();
            }finally {
                lock.unlock();
            }
        }

        public void main(int i)  {
            lock.lock();
            try{
                while(bShouldSub){
                    try{
                        condition.await();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

                for (int j = 0; j <= 10; j++) {
                    System.out.println("main thread " + i + "-" + j);
                }
                bShouldSub=true;
                condition.signal();

            }finally {
                lock.unlock();
            }

        }
    }
}
