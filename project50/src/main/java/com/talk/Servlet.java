package com.talk;

public class Servlet {

    public synchronized void doGet(){
        try{
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("--doGet--"+Thread.currentThread().getId());
    }

}
