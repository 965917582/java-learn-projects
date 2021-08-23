package com.project43.wather;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

public class W1 implements Watcher {
    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("event");
    }
}
