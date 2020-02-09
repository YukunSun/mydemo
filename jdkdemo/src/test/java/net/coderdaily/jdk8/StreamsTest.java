package net.coderdaily.jdk8;

import net.coderdaily.jdk8.util.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Author: sunyukun@xueqiu.com
 * Time: 2018/4/19 下午9:07
 * Desc:
 */
public class StreamsTest {
    /**
     * stream
     */
    @Test
    public void streamTest() {
        List<Integer> list = Stream.of(1, 2, 3, 4).collect(Collectors.toList());
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4), list);
    }

    /**
     * 遍历元素
     */
    @Test
    public void forEach() {
        Random random = new Random();
//        输出随机数
        random.ints().forEach(System.out::println);
    }

    /**
     * 用于减少stream的元素个数
     */
    @Test
    public void limit() {
        Random random = new Random();
//        输出10个随机数
        random.ints().limit(10).forEach(System.out::println);
    }


    /**
     * 用于排序
     */
    // FIXME: 2018/4/19 顺序
    @Test
    public void sorted() {
        Random random = new Random();
//        生成排好序的10个随机数
        random.ints().limit(10).sorted().forEach(System.out::println);
    }

    /**
     * 绑定每一个元素到它相关的结果
     */
    @Test
    public void map() {
//        求平方并去重
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> squareLists = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.println(squareLists);
    }

    /**
     * 可以使用 map 将一种类型转化为另一种类型
     */
    @Test
    public void mapTest() {
        List<String> list = Stream.of("foo", "bar")
                .map(str -> str.toUpperCase())
                .collect(Collectors.toList());
        Assert.assertEquals(Arrays.asList("FOO", "BAR"), list);
    }

    /**
     * flatMap
     */
    @Test
    public void flatMapTest() {
        List<Integer> list = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
                .flatMap(numbers -> numbers.stream())
                .collect(Collectors.toList());
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4), list);
    }

    /**
     * 基于一个标准去排除元素
     */
    @Test
    public void filter() {
//        求有几个空元素
        List<String> list = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl", "");
        long count = list.stream().filter(string -> string.isEmpty()).count();
        System.out.println(count);
    }

    /**
     * 用于并发计算
     */
    @Test
    public void parallel() {
//        求有几个空元素
        List<String> list = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl", "");
        long count = list.stream().parallel().filter(string -> string.isEmpty()).count();
        System.out.println(count);
    }

    /**
     * 用于组合流的元素的处理结果
     */
    @Test
    public void collectors() {
        List<String> list = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl", "");
//        获取非空的元素
        List<String> filtered = list.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());

        System.out.println("not null list:" + filtered);
//        将非空元素拼接成字符串
        String strings = list.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(", "));
        System.out.println(strings);
    }

    /**
     * 使用Java 8时，引入统计信息收集器来计算流处理完成时的所有统计信息。
     */
    @Test
    public void statistics() {
        List integers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics statistics = integers.stream().mapToInt(x -> (int) x).summaryStatistics();
        System.out.println("getMax:" + statistics.getMax());
        System.out.println("getAverage:" + statistics.getAverage());
        System.out.println("getCount:" + statistics.getCount());
        System.out.println("getSum:" + statistics.getSum());
        System.out.println("getMin:" + statistics.getMin());
    }

    @Test
    public void extremum() {
        IntStream intStream = IntStream.range(1, 10);
        Assert.assertEquals(9, intStream.max().getAsInt());
        Assert.assertEquals(1, intStream.min().getAsInt());
    }

    @Test
    public void extremum2() {
        List<User> users = Arrays.asList(new User("foo", 22),
                new User("bar", 25),
                new User("sunyk", 18));
        User youngest = users.stream()
                .min(Comparator.comparing(user -> user.getAge()))
                .get();
        Assert.assertEquals(users.get(2), youngest);

        User oldest = users.stream()
                .max(Comparator.comparing(User::getAge))//法二
                .get();
        Assert.assertEquals(users.get(1), oldest);
    }
}
