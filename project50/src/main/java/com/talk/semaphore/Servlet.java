package com.talk.semaphore;

import java.util.concurrent.Semaphore;

public class Servlet {
    Semaphore sp = new Semaphore(2);

    public Semaphore getSemaphore(){
        return this.sp;
    }

}
