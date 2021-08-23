package com.project39.config;

import com.project39.component.LoginHandlerInterceptor;
import com.project39.component.MyLocaleResolver;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * mvc的扩展功能配置
 * 使用WebMvcConfigurerAdapter可以来扩展springmvc的功能
 * 打@EnableWebMvc是springboot不要接管springmvc
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    public  void addViewController(ViewControllerRegistry registry){
        //添加视图映射
        registry.addViewController("/blabla").setViewName("success");
    }

    //由于所有的WebMvcConfigurerAdapter组件都会一起起作用，所以可以添加一个这个组件
    //来完成对在模板文件夹下index.html的视图映射
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        //因为是接口所以直接实现(ctrl+o看可实现的方法)
        WebMvcConfigurer configurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/","/user/login");
            }
        };
        return configurer;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }


}
