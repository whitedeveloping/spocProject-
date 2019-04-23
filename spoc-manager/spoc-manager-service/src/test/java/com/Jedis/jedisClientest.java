package com.Jedis;

import com.common.jedis.JedisClient;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class jedisClientest {
    @Test
    public void testJedisClient() throws Exception {
        //初始化Spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-redis.xml");
        //从容器中获得JedisClient对象
        JedisClient jedisClient = applicationContext.getBean(JedisClient.class);
        jedisClient.set("mytest", "jedisClient");
        String result = jedisClient.get("mytest");
        System.out.println(result);


    }
}
