package net.coderdaily.application;

import net.coderdaily.util.AbstractJedis;
import org.junit.Test;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.io.IOException;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019-06-30 15:37
 * Blog: coderdaily.net
 */
public class SimpleRateLimiterTest extends AbstractJedis {
    /**
     * 每一个 key 存储一个 zset，每个 key 的 score 都是当前时间的毫秒值， 且过期时间每次存储时都增加
     *
     * @param userId
     * @param actionKey
     * @param period    单位：秒
     * @param maxCount
     * @return
     * @throws IOException
     */
    public boolean isActionAllowed(String userId, String actionKey, int period, int maxCount) throws IOException {
        String key = String.format("limit:%s:%s", userId, actionKey);
        long nowTs = System.currentTimeMillis();
        Pipeline pipe = jedis.pipelined();

        pipe.multi();
        pipe.zadd(key, nowTs, "" + nowTs);
        pipe.zremrangeByScore(key, 0, nowTs - period * 1000);
        Response<Long> count = pipe.zcard(key);
        pipe.expire(key, period + 1);
        pipe.exec();
        pipe.close();
        long countValue = count.get();
        System.out.println(countValue);
        return countValue <= maxCount;
    }

    /**
     * 简单的一个限流
     *
     * @throws IOException
     */
    @Test
    public void simpleRateLimit() throws IOException, InterruptedException {
        for (int i = 0; i < 20; i++) {
            System.out.print("i:" + i + ",time：" + System.currentTimeMillis());
            //60s 内，限制买2次
            boolean reuslt = this.isActionAllowed("U1234", "buy-apple", 60, 2);
            if (reuslt) {
                System.out.println("can buy...");
            } else {
                System.out.println("can't buy...");
            }
        }
    }
}