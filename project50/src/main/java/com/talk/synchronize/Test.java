package com.talk.synchronize;

public class Test {

    public static void main(String[] args) {

        new Thread(new R()).start();
        new Thread(new R()).start();

    }
}
