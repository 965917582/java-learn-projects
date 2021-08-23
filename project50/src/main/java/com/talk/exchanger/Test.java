package com.talk.exchanger;


public class Test {

    public static void main(String[] args) {
        Servlet s = new Servlet();

        new Thread(new R1(s,"hahaha")).start();
        new Thread(new R1(s,"heihei")).start();


    }

}
