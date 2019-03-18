package com.kwb.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisTest {
    private static JedisPool jedisPool = new JedisPool("47.103.2.86",6379);
    private static Jedis jedis;


    public static void main(String[] args) {
        jedis = jedisPool.getResource();
//        jedis.del("name");
        jedis.lpush("name", "kwb","zyh","cao");
        System.out.println(jedis.lpop("name"));
    }
}
