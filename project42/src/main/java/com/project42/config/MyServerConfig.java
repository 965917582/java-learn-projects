package com.project42.config;

import com.project42.lisener.StartupLisener;
import com.project42.wather.W1;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyServerConfig {
    //注册监听器
    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean<StartupLisener> listenerRegistrationBean = new ServletListenerRegistrationBean<>(new StartupLisener());
        return listenerRegistrationBean;
    }

}
