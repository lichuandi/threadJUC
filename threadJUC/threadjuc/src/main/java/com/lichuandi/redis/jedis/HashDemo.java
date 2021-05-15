package com.lichuandi.redis.jedis;

//import com.crazymakercircle.util.Logger;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * create by 尼恩 @ 疯狂创客圈
 **/
public class HashDemo {


    /**
     * Redis hash 是一个string类型的field和value的映射表，
     * hash特别适合用于存储对象。
     * Redis 中每个 hash 可以存储 2^32 - 1 键值对（40多亿）
     */
    @Test
    public void operateHash() {
        Logger logger = Logger.getGlobal();
        Jedis jedis = new Jedis("localhost");
        jedis.del("config");
        //设置hash的 field-value 对
        jedis.hset("config", "ip", "127.0.0.1");


        //取得hash的 field的关联的value值
        logger.info("jedis.hget(): " + jedis.hget("config", "ip"));
        //取得类型：hash
        logger.info("jedis.type(): " + jedis.type("config"));

        //批量添加 field-value 对，参数为java map
        Map<String, String> configFields = new HashMap<String, String>();
        configFields.put("port", "8080");
        configFields.put("maxalive", "3600");
        configFields.put("weight", "1.0");
        //执行批量添加
        jedis.hmset("config", configFields);
        //批量获取：取得全部 field-value 对，返回 java map
        logger.info("jedis.hgetAll(): " + jedis.hgetAll("config"));
        //批量获取：取得部分 field对应的value，返回 java map
        logger.info("jedis.hmget(): " + jedis.hmget("config", "ip", "port"));

        //浮点数增加: 类似于String的 incrByFloat
        jedis.hincrByFloat("config", "weight", 1.2);
        logger.info("jedis.hget(weight): " + jedis.hget("config", "weight"));

        //获取所有的key
        logger.info("jedis.hkeys(config): " + jedis.hkeys("config"));
        //获取所有的val
        logger.info("jedis.hvals(config): " + jedis.hvals("config"));

        //获取长度
        logger.info("jedis.hlen(): " + jedis.hlen("config"));
        //判断field是否存在
        logger.info("jedis.hexists(weight): " + jedis.hexists("config", "weight"));

        //删除一个field
        jedis.hdel("config", "weight");
        logger.info("jedis.hexists(weight): " + jedis.hexists("config", "weight"));


        jedis.close();
    }


}
