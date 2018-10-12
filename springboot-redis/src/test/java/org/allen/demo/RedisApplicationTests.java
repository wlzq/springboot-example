package org.allen.demo;

import org.allen.demo.domain.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSet(){
        redisTemplate.opsForValue().set("cityInfoStr", new City(1, "BJ", "北京").toString());
        System.out.println("获取字符串值："+redisTemplate.opsForValue().get("cityInfoStr"));

        List<City> list = Collections.synchronizedList(new ArrayList<City>());
        list.add(new City(1,"BJ","beijing"));
        list.add(new City(2,"SH","shanghai"));
        redisTemplate.opsForList().leftPush("cityList", list);
        System.out.println("获取集合值："+redisTemplate.opsForList().index("cityList",1));
    }

}
