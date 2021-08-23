package com.project41.config;

import com.project41.listener.StartupListener;
import com.project41.watcher.W1;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyServerConfig {

    //zookeeper bean
    @Bean
    public ZooKeeper zooKeeper(){
        System.out.println("a1项目启动");
        ZooKeeper zooKeeper =null;
        try {
            W1 w1 = new W1();
            zooKeeper = new ZooKeeper("127.0.0.1:2181", 10000, w1);
            w1.setZk(zooKeeper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return zooKeeper;
    }


    //注册监听器
    /*@Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean<StartupListener> listenerRegistrationBean = new ServletListenerRegistrationBean<>(new StartupListener());
        return listenerRegistrationBean;
    }*/
}
