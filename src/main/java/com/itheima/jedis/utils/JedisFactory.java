package com.itheima.jedis.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisFactory {
    private static final JedisPool JEDIS_POOL;

    static {
        //配置连接池
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //设置最大连接数
        jedisPoolConfig.setMaxTotal(8);
        //设置最大空闲连接
        jedisPoolConfig.setMaxIdle(8);
        //设置最小连接数
        jedisPoolConfig.setMinIdle(0);
        //设置最大等待时长
        jedisPoolConfig.setMaxWaitMillis(1000);
        //创建连接池对象
        JEDIS_POOL = new JedisPool(jedisPoolConfig, "192.168.75.128", 6379, 3000);
    }
    //创建jedis对象
    public static Jedis getJedis() {
        System.out.println("hot-fix");
        return JEDIS_POOL.getResource();
    }
    public static void main(String[] args) {
        System.out.println("测试一下git------------------");
        System.out.println("测试一下git2");
    }
}
