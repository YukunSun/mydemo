package net.coderdaily.string;

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

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2018/3/1 下午3:28
 * Blog: coderdaily.net
 * <p>
 * 文档：http://doc.redisfans.com/#ctrl-f
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class StringTest {
    @Autowired
    private CustomJedisConfig customJedisConfig;

    @Test
    public void get() {
        Jedis jedis = customJedisConfig.getJedis();
        jedis.set("foo", "bar");
        String result = jedis.get("foo");
        System.out.println(result);
    }

    @Test
    public void del() {
        Jedis jedis = customJedisConfig.getJedis();
        jedis.set("foo", "bar");
        String result = jedis.get("foo");
        System.out.println(result);

        jedis.del("foo");
        System.out.println(jedis.get("foo"));
    }



}
