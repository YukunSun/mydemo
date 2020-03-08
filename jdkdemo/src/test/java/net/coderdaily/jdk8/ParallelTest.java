package net.coderdaily.jdk8;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2020/3/8 22:25
 * Blog: coderdaily.net
 */
public class ParallelTest {
    /**
     * 模拟扔骰子，蒙特卡洛模拟法
     */
    @Test
    public void twoDiceThrowTest() {
        final Integer N = 1000000;
        double fraction = 1.0 / N;
        Map<Integer, Double> result = IntStream.range(0, N)
                .parallel()
                .mapToObj(i -> twoDiceThrows(ThreadLocalRandom.current()))
                //计算频率:这个实现比较巧妙，假如 side 出现 n 次，相当于 n 个 faraction 相加，也就省略了 次数*faction 那一步了（省略了计算次数）
                .collect(Collectors.groupingBy(side -> side, Collectors.summingDouble(side -> fraction)));
        System.out.println("result = " + result);

        double valid = result.values().stream().mapToDouble(Double::doubleValue).summaryStatistics().getSum();
        Assert.assertEquals(1.0, valid, 0.000001);
    }

    private Integer twoDiceThrows(ThreadLocalRandom random) {
        int firstThrow = random.nextInt(1, 7);
        int secondThrow = random.nextInt(1, 7);
        return firstThrow + secondThrow;
    }
}
