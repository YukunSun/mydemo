package net.coderdaily.list;

import net.coderdaily.util.CustomJedisConfig;
import net.coderdaily.util.Foo;
import net.coderdaily.util.SerializeUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.BinaryClient;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2018/3/4 下午12:34
 * Blog: coderdaily.net
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ListTest {
    @Autowired
    private CustomJedisConfig customJedisConfig;
    @Autowired
    private SerializeUtil serializeUtil;

    private Jedis jedis;

    @Before
    public void getJedis() {
        jedis = customJedisConfig.getJedis();
    }

    @Test
    public void l_all_operation() {
        jedis.lpush("lkey", "a", "b", "c");
        System.out.println(jedis.lrange("lkey", 0, 10));


        jedis.lpush("lkey", "d", "e");
        System.out.println(jedis.lrange("lkey", 0, 10));

        jedis.lpop("lkey");
        System.out.println(jedis.lrange("lkey", 0, 10));

        System.out.println(jedis.lindex("lkey", 2));
    }

    /**
     * 将值 value 插入到列表 key 当中，位于值 pivot 之前或之后。
     * <p>
     * 当 pivot 不存在于列表 key 时，不执行任何操作。
     * <p>
     * 当 key 不存在时， key 被视为空列表，不执行任何操作。
     * <p>
     * 如果 key 不是列表类型，返回一个错误。
     */
    @Test
    public void linsert() {
        System.out.println(jedis.lrange("lkey", 0, 10));
        jedis.linsert("lkey", BinaryClient.LIST_POSITION.BEFORE, "c", "f");
        System.out.println(jedis.lrange("lkey", 0, 10));
    }

    @Test
    public void del() {
        jedis.del("lkey");
    }


    @Test
    public void test_object() {
        List<Foo> list = new ArrayList<Foo>(10);
        for (int i = 0; i < 10; i++) {
            list.add(new Foo());
        }
        jedis.lpush("lkey2", serializeUtil.serialize(list));
        System.out.println(jedis.lpop("lkey2"));
    }
}
