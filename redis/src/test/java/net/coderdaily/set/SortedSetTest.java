package net.coderdaily.set;

import net.coderdaily.util.CustomJedisConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2018/3/4 下午2:09
 * Blog: coderdaily.net
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SortedSetTest {
    @Autowired
    private CustomJedisConfig customJedisConfig;

    private Jedis jedis;

    @Before
    public void getJedis() {
        jedis = customJedisConfig.getJedis();
    }

    @Test
    public void ss_all_operation() {
        jedis.zadd("zkey", 1, "m1");
        jedis.zadd("zkey", 2, "m2");
        jedis.zadd("zkey", 3, "m3");
        System.out.println(jedis.objectEncoding("zkey"));
        System.out.println(jedis.zscan("zkey", 0).getResult());
        System.out.println(jedis.zrange("zkey", 0, 10));
    }
}
