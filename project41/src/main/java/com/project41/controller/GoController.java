package com.project41.controller;

import com.project41.util.HttpClientUtil;
import com.project41.watcher.W1;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoController {
    //获取zooKeeper对象
    @Autowired
    ZooKeeper zooKeeper;
    boolean a1Visited = false;

    //向A项目发请求
    @GetMapping("go")
    public String go() throws Exception {
        //获取子节点列表
        List<String> children = zooKeeper.getChildren("/servers", true);
        System.out.println(children);

        //简单的负载均衡策略:
        //如果两个都工作，就轮流访问；如果只有一个就访问这个；如果没有就返回访问失败
        //如果报错也返回失败(项目关闭后zookeeper不能及时同步)
        try{

            if(children.size()==2){
                String data=null;
                if(a1Visited){
                    //访问a2
                    data = new String(zooKeeper.getData("/servers/" + children.get(1), true, new Stat()));
                }else{
                    //访问a1
                    data = new String(zooKeeper.getData("/servers/" + children.get(0), true, new Stat()));
                }
                String[] split = data.split("-");
                HttpClientUtil.doGet("http://"+split[0]+":"+split[1]+"/accept");
                a1Visited = !a1Visited;

            }else if(children.size()==1){
                String data = new String(zooKeeper.getData("/servers/" + children.get(0), true, new Stat()));
                String[] split = data.split("-");
                HttpClientUtil.doGet("http://"+split[0]+":"+split[1]+"/accept");

            }else{
                return "fail";
            }

        }catch (Exception e){
            return "fail";
        }


        return "success";
    }

}
