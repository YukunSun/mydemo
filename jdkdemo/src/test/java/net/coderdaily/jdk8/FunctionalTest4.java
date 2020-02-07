package net.coderdaily.jdk8;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2020/2/7 22:47
 * Blog: coderdaily.net
 */
public class FunctionalTest4 {
    @Test
    public void predicateTest() {
        Predicate<Integer> greaterThan5 = x -> x > 5;
        System.out.println("greaterThan5 = " + greaterThan5.test(6));
        System.out.println("greaterThan5 = " + greaterThan5.test(2));

        Predicate<Integer> predicate2 = x -> x * x < 64;
        //7 是否满足 7>5 && 7*7<64，下同
        Assert.assertEquals(true, greaterThan5.and(predicate2).test(7));
        Assert.assertEquals(false, greaterThan5.and(predicate2).test(8));

        //hello != world
        Predicate predicate3 = Predicate.isEqual("hello");
        Assert.assertEquals(predicate3.test("world"), false);
    }

    @Test
    public void binaryOperatorTest() {
        BinaryOperator<Integer> add = (x, y) -> x + y;
        System.out.println("add = " + add.apply(1, 2));

        BinaryOperator<Integer> muti = (x, y) -> x * y;
        System.out.println("muti.apply(2,3) = " + muti.apply(2, 3));
    }

    @Test
    public void unaryOperatorTest() {
        UnaryOperator<Integer> square = x -> x * x;
        System.out.println("square.apply(4) = " + square.apply(4));
    }

    /**
     * 自定义函数接口
     */
    @Test
    public void customizeFunction() {
        Function<Long, Long> function = x -> x + 5;
        System.out.println("function.apply(1) = " + function.apply(1L));
    }
}

interface Function<T, R> {
    R apply(T t);
}