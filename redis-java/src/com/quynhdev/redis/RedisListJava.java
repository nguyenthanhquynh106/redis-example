package com.quynhdev.redis;

import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisListJava {
    public static void main(String[] args) {
        //Connecting to Redis on localhost
        Jedis jedis = new Jedis("localhost");
        System.out.println("Kết nối thành công đến server!");

        //Store data in Redis List
        jedis.lpush("skills", "Java");
        jedis.lpush("skills", "Spring");
        jedis.lpush("skills", "MongoDB");

        //Get the stored data and print it
        List<String> mySkills = jedis.lrange("skills", 0, -1);

        for(int i = 0; i < mySkills.size(); i++) {
            System.out.println("Stored string in Redis: " + mySkills.get(i));
        }
    }
}
