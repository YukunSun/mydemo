package net.coderdaily.jdk8;

import net.coderdaily.jdk8.util.PrimeUtil;
import org.junit.Test;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019/9/22 22:19
 * Blog: coderdaily.net
 */
public class FunctionalTest3 {
    /**
     * 判断1~100000的质数的个数
     */
    @Test
    public void f1() {
        long begin = System.currentTimeMillis();
        long count = IntStream.range(1, 10000000).filter(PrimeUtil::isPrime).count();
        long now = System.currentTimeMillis();
        System.out.println("count: " + count + ",spend time:" + (now - begin));//count: 664579,spend time:6580
    }

    /**
     * 变为并行流
     */
    @Test
    public void f1Compare() {
        long begin = System.currentTimeMillis();
        long count = IntStream.range(1, 10000000).parallel().filter(PrimeUtil::isPrime).count();
        long now = System.currentTimeMillis();
        System.out.println("count: " + count + ",spend time:" + (now - begin));//count: 664579,spend time:4492
    }

    @Test
    public void f2() {
        int[] arr = new int[99999999];
        Random r = new Random();

        long begin = System.currentTimeMillis();
        Arrays.setAll(arr, (i) -> r.nextInt());
        long now = System.currentTimeMillis();

        Arrays.stream(arr).limit(5).forEach(System.out::println);
        System.out.println("spend time:" + (now - begin));//spend time:1839
    }

    //????貌似没有什么效果
    @Test
    public void f2Compare() {
        Random r = new Random();
        int[] arr = new int[99999999];

        long begin = System.currentTimeMillis();
        Arrays.parallelSetAll(arr, (i) -> r.nextInt());
        long now = System.currentTimeMillis();

        Arrays.stream(arr).limit(5).forEach(System.out::println);
        System.out.println("spend time:" + (now - begin));//spend time:4501
    }


    public final static ThreadLocal<DateFormatter> formatter = ThreadLocal.withInitial(() -> new DateFormatter(new SimpleDateFormat("yyyy-MM-dd")));

    /**
     * 使用 ThreadLocal 保证 SimpleDateFormat 线程安全
     */
    @Test
    public void simpleDateFormatByThreadLocal() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println("formatter(safe) = " + formatter.get().getFormat().format(new Date()));
//                System.out.println("formatter(not safe) = " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            }).start();
        }
        Thread.currentThread().join();
    }
}
