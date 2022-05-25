package com.example.redisspringdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@Controller //contrllor必须加这个
public class testController {
    @RestController

    public class RedisTestController {
        @Autowired
        private RedisTemplate redisTemplate;

        @RequestMapping("/redisTest")
        public String testRedis() {
            //设置值到redis
            redisTemplate.opsForValue().set("name","学习java可看码农研究僧的博客地址，https://blog.csdn.net/weixin_47872288");
            //从redis获取值
            redisTemplate.opsForSet().add("name2","学习java可看码农研究僧的博客地址","nihao");
            String name = (String)redisTemplate.opsForValue().get("name");
            Set set = redisTemplate.opsForSet().members("name2");
            for (Object str : set) {
                System.out.println(str);
            }
            return name;
        }
    }

}
