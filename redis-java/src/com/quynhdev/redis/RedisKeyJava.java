package com.quynhdev.redis;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class RedisKeyJava {
    public static void main(String[] args) {
        //Connecting to Redis on localhost
        Jedis jedis = new Jedis("localhost");
        System.out.println("Kết nối thành công đến server!");

        //Get the stored key and print it
        Set<String> keys = jedis.keys("*");

        for (String key : keys) {
            System.out.println("Stored key: " + key);
        }
    }
}
