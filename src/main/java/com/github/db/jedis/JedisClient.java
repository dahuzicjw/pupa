package com.github.db.jedis;

import redis.clients.jedis.Jedis;

public class JedisClient {

    static Jedis jedis;
    static {
        jedis = new Jedis("127.0.0.1", 6380);
//        jedis.auth("");
    }
    

}
