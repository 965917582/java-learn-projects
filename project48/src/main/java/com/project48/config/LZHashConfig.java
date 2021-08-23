package com.project48.config;

import com.project48.util.LZHash;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 把LZHash初始化并放入ioc容器(其实不用实例化，这里只是初始化虚拟节点)
 */
@Configuration
public class LZHashConfig {

    @Bean
    public LZHash lzHash(){
        List<String> realNodes = new ArrayList<String>();
        realNodes.add("127.0.0.1:6379");
        realNodes.add("127.0.0.1:6380");
        //realNodes.add("127.0.0.1:6381");
        LZHash h = new LZHash(realNodes);
        return h;
    }
}
