package net.coderdaily.set;

import net.coderdaily.util.CustomJedisConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2018/3/4 下午1:37
 * Blog: coderdaily.net
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SetTest {
    @Autowired
    private CustomJedisConfig customJedisConfig;

    private Jedis jedis;

    @Before
    public void getJedis() {
        jedis = customJedisConfig.getJedis();
    }

    @Test
    public void s_all_operation() {
        jedis.sadd("skey", "m1", "m2");
        System.out.println(jedis.smembers("skey"));

        jedis.sadd("skey2", "m2", "m3");

//        返回一个集合的全部成员，该集合是所有给定集合之间的差集。
        System.out.println(jedis.sdiff("skey", "skey2"));

//        返回交集
        System.out.println(jedis.sinter("skey", "skey2"));

//        交集操作之后，存储到一个集合中，时间复杂度：O(N * M)， N 为给定集合当中基数最小的集合， M 为给定集合的个数。
        System.out.println(jedis.sinterstore("skey3", "skey", "skey2"));
        System.out.println(jedis.smembers("skey3"));
    }
}
