package net.coderdaily.hash;

import net.coderdaily.util.CustomJedisConfig;
import net.coderdaily.util.Foo;
import net.coderdaily.util.SerializeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

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
    @Autowired
    private SerializeUtil serializeUtil;

    @Test
    public void hget() {
        Jedis jedis = customJedisConfig.getJedis();
        final String FIELD_ID = "id";
        final String FIELD_NAME = "name";
        final String FIELD_AGE = "age";
        final Long ID = 1L;

        Foo f1 = new Foo(1L, "f1", 11);
        jedis.hset(Long.toString(f1.getId()), FIELD_NAME, f1.getName());
        jedis.hset(Long.toString(f1.getId()), FIELD_AGE, Long.toString(f1.getAge()));

        Foo f2 = new Foo(2L, "f2", 12);
        jedis.hset(Long.toString(f2.getId()), FIELD_NAME, f2.getName());
        jedis.hset(Long.toString(f2.getId()), FIELD_AGE, Long.toString(f2.getAge()));

        String name = jedis.hget(Long.toString(ID), FIELD_NAME);
        System.out.println(name);//f1

        String age = jedis.hget(Long.toString(ID), FIELD_AGE);
        System.out.println(age);//11

        Map<String, String> map = jedis.hgetAll(Long.toString(ID));
        System.out.println(map);//{name=f1, age=11}
    }
}