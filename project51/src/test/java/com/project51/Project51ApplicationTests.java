package com.project51;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class Project51ApplicationTests {
    @Autowired
    RabbitTemplate rabbitTemplate;


    @Test
    void contextLoads() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg","这是第一个消息");
        map.put("data", Arrays.asList("helloworld",123,true) );
        rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",map);

    }

    @Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(o.getClass() );
        System.out.println(o);
    }


}
