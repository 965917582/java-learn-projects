package com.project43.config;

import com.project43.lisener.StartupLisener;
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
