package net.coderdaily.hash;

import net.coderdaily.util.CustomJedisConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Map;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2018/3/1 下午5:17
 * Blog: coderdaily.net
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class HashTest {
    @Autowired
    private CustomJedisConfig customJedisConfig;

    @Test
    public void hget() {
        Jedis jedis = customJedisConfig.getJedis();
        jedis.hset("h1", "f0", "0");
        jedis.hset("h1", "f1", "1");
        jedis.hset("h1", "f2", "2");
        jedis.hset("h1", "f3", "2");
        jedis.hset("h1", "f4", "4");

        String r = jedis.hget("h1", "f2");
        System.out.println(r);

        Map<String, String> map = jedis.hgetAll("h1");
        System.out.println(map);
    }
}
