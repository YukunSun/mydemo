package net.coderdaily.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2018/3/1 下午5:20
 * Blog: coderdaily.net
 * <p>
 * 私人定制的配置类
 */
@Component
public class CustomJedisConfig {
    @Value("${REDIS_HOST}")
    private String REDIS_HOST;

    /**
     * 获取jedisPool
     *
     * @return
     */
    public JedisPool getJedisPool() {
        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), REDIS_HOST);
        return jedisPool;
    }

    /**
     * 获取jedis
     *
     * @return
     */
    public Jedis getJedis() {
        return this.getJedisPool().getResource();
    }
}
