package com.project42.lisener;

import com.project42.wather.W1;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;

/**
 * 项目启动时，
 * 连接zookeeper
 * 把本项目临时节点挂上zookeeper
 */
public class StartupLisener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("a1项目启动");
        try {
            ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181", 10000, new W1());
            zooKeeper.create("/servers/a1","127.0.0.1-8081".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
