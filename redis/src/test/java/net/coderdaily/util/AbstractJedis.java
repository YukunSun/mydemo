package net.coderdaily.util;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019-06-30 15:50
 * Blog: coderdaily.net
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AbstractJedis {
    @Autowired
    private CustomJedisConfig customJedisConfig;

    public Jedis jedis;

    @Before
    public void getJedis() {
        jedis = customJedisConfig.getJedis();
    }
}
