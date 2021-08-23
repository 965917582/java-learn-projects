package com.pojo;

import java.util.ArrayList;
import java.util.List;

public class Passengers {
    private List<OrderPassenger> passengers = new ArrayList<>();

    public List<OrderPassenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<OrderPassenger> passengers) {
        this.passengers = passengers;
    }
}
