package com.project43.lisener;

import com.project43.wather.W1;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 项目启动时，
 * 连接zookeeper
 * 把本项目临时节点挂上zookeeper
 */
public class StartupLisener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("a2项目启动");
        try {
            ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181", 10000, new W1());
            zooKeeper.create("/servers/a2","127.0.0.1-8082".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
