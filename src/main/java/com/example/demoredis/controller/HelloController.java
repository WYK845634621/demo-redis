package com.example.demoredis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisCluster;

/**
 * @Description
 * @Tips
 * @Author yikai.wang
 * @Date 2020/3/24 10:51
 */
@RestController
@Slf4j
public class HelloController {


    @Autowired
    private JedisCluster jedisCluster;  //自动释放连接

    @GetMapping("/hello")
    public String h(){
        jedisCluster.set("hello","hello-value");
        log.info("已放入redis.......");
        return "hello";
    }
}
