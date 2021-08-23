package com.project49;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.project49.mapper")
@SpringBootApplication
@EnableCaching
public class Project49Application {

    public static void main(String[] args) {
        SpringApplication.run(Project49Application.class, args);
    }

}
