package com.project41.listener;

import com.project41.watcher.W1;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;

/**
 * 【弃用】
 * 监听项目启动
 * 创建zookeeper对象，连接zookeeper，
 * 使它一直存在
 */
public class StartupListener  implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            W1 w1 = new W1();
            ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181", 10000, w1);
            w1.setZk(zooKeeper);

            //放入容器
            WebApplicationContext currentWebApplicationContext = ContextLoader.getCurrentWebApplicationContext();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
