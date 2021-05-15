package com.lichuandi.redis.jedisPool;

//import com.crazymakercircle.util.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * create by 尼恩 @ 疯狂创客圈
 **/
public class JredisPoolBuilder {

    public static final int MAX_IDLE = 50;
    public static final int MAX_TOTAL = 50;
    private static JedisPool pool = null;
    private static org.slf4j.Logger logger;
   // Logger logger = Logger.getGlobal();
    static {
        //创建连接池
        buildPool();
        //预热连接池
        hotPool();
    }

    //创建连接池
    private static JedisPool buildPool() {

        if (pool == null) {
            long start = System.currentTimeMillis();
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(MAX_TOTAL);
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWaitMillis(1000 * 10);
            // 在borrow一个jedis实例时，是否提前进行validate操作；
            // 如果为true，则得到的jedis实例均是可用的；
            config.setTestOnBorrow(true);
            //new JedisPool(config, ADDR, PORT, TIMEOUT, AUTH);
            pool = new JedisPool(config, "127.0.0.1", 6379, 10000);
            long end = System.currentTimeMillis();
            logger.info("buildPool  毫秒数:", end - start);
        }
        return pool;
    }

    //获取连接，供其他模块使用
    public synchronized static Jedis getJedis() {
        return pool.getResource();
    }
     //为了提升初次访问的性能考虑在JedisPool创建后为了JedisPool提前进行预热，最小空闲数量尾预热数量
    //连接池的预热
    public static void hotPool() {

        long start = System.currentTimeMillis();
        List<Jedis> minIdleJedisList = new ArrayList<Jedis>(MAX_IDLE);
        Jedis jedis = null;

        for (int i = 0; i < MAX_IDLE; i++) {
            try {
                jedis = pool.getResource();
                minIdleJedisList.add(jedis);
                jedis.ping();
            } catch (Exception e) {
                logger.error(e.getMessage());
            } finally {
            }
        }

        for (int i = 0; i < MAX_IDLE; i++) {
            try {
                jedis = minIdleJedisList.get(i);
                jedis.close();
            } catch (Exception e) {
                logger.error(e.getMessage());
            } finally {

            }
        }
        long end = System.currentTimeMillis();
        logger.info("hotPool  毫秒数:", end - start);

    }


}