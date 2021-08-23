package com.talk.exchanger;

import java.util.concurrent.Exchanger;

public class Servlet {
    Exchanger exchanger = new Exchanger();

    public Exchanger getExchanger(){
        return this.exchanger;
    }

}
