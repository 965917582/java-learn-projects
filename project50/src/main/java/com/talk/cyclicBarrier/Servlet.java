package com.talk.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Servlet {
    CyclicBarrier cb = new CyclicBarrier(3);

    public CyclicBarrier getCyclicBarrier(){
        return this.cb;
    }

}
