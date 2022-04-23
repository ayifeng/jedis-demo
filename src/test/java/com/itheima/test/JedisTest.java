package com.itheima.test;

import com.itheima.jedis.utils.JedisFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

public class JedisTest {
    private Jedis jedis;

    @BeforeEach
    void setUp() {
        //建立连接
        jedis = JedisFactory.getJedis();
//        jedis = new Jedis("192.168.75.128", 6379);
        //设置密码，没有密码则不设置
//        jedis.auth(null);
        //选择库
        jedis.select(0);
    }

    @Test
    void testString() {
        String result = jedis.set("name", "jack");
        System.out.println(result);
        String name = jedis.get("name");
        System.out.println(name);
    }

    @Test
    void testHash() {
        jedis.hset("user:1", "name", "傻蛋");
        jedis.hset("user:1", "age", "18");
        jedis.hset("user:1", "sex", "女人");
        System.out.println(jedis.hgetAll("user:1"));
    }

    @AfterEach
    void afterAll() {
        if (jedis != null) {
            jedis.close();
            System.out.println("jedis已关闭！");
        }
    }
}
