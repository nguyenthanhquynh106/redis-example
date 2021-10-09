package com.quynhdev.redis;

import redis.clients.jedis.Jedis;

public class RedisStringJava {
    public static void main(String[] args) {
        //Connecting to Redis server on localhost
        Jedis jedis = new Jedis("Localhost");
        System.out.println("Kết nối thành công đến server!");

        //Set the data in Redis String
        jedis.set("my-name", "Nguyen Thanh Quynh");

        //Get the stored data and print it
        System.out.println("Stored string in Redis: " + jedis.get("my-name"));
    }
}
