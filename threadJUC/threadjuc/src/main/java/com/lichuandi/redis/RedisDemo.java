package com.lichuandi.redis;

import org.slf4j.Logger;
import redis.clients.jedis.Jedis;



/**
 * @Auther digege
 * @Date 2021/5/3
 * @Description：com.lichuandi.redis version：1
 */
public class RedisDemo {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
       // jedis.auth();//如果有就设置
       // Logger.info();
        System.out.println(jedis.ping());
        jedis.set("myJavaString","lichuandi");
        System.out.println(jedis.type("myJavaString"));
        jedis.close();
    }
}
