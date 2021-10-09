package com.quynhdev.redis;

import redis.clients.jedis.Jedis;

public class RedisJava {
    public static void main(String[] args) {
        //Connecting to Redis server on localhost
        Jedis jedis = new Jedis("localhost");
        System.out.println("Kết nối thành công đến server!");

        //Check whether server is running or not?
        System.out.println("Server đang chạy: " + jedis.ping());
    }
}
