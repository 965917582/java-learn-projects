package com.talk;


public class Test {

    public static void main(String[] args) {
        Servlet servlet = new Servlet();

        new Thread(new R1(servlet)).start();
        new Thread(new R1(servlet)).start();

    }

}
