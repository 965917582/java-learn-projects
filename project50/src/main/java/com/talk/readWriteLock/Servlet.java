package com.talk.readWriteLock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 数据
 */
public class Servlet {
    private Object data=null;//共享数据
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ReentrantReadWriteLock getRwl() {
        return rwl;
    }

    public void setRwl(ReentrantReadWriteLock rwl) {
        this.rwl = rwl;
    }
}
