package com;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 关于多线程读写锁
 *
 * 设计一个缓存系统
 */
public class CacheDemo {
    private Map<String,Object> cache = new HashMap<String,Object>();

    public static void main(String[] args) {

    }

    private ReadWriteLock rwl = new ReentrantReadWriteLock();
    public Object getData(String key){
        rwl.readLock().lock();
        Object value = null;
        try{
            value = cache.get(key);
            if(value == null){
                rwl.readLock().unlock();
                rwl.writeLock().lock();
                try{
                    if(value==null){//处理当多个线程都到达读锁unlock后，第一个将写入缓存，后面的都不再写缓存
                        value = "aaa";//实际去查数据库
                    }
                }finally {
                    rwl.writeLock().unlock();
                }
                //回归原装
                rwl.readLock().lock();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwl.readLock().unlock();
        }
        return value;
    }
}
