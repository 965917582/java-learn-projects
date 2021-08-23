package com.project41.watcher;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class W1 implements Watcher {
    ZooKeeper zk;
    public void setZk(ZooKeeper zk){
        this.zk=zk;
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        try {
            //保持监听
            zk.getChildren("/servers",true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("监听到zookeeper变化");
    }
}
