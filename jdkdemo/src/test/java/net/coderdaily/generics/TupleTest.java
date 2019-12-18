package net.coderdaily.generics;

import org.junit.Test;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019/12/11 23:38
 * Blog: coderdaily.net
 * <p>
 * 实现一个元组：只能传递对象不能修改或添加
 */
public class TupleTest {
    @Test
    public void tupleTest() {
        TwoTuple<String, Integer> twoTuple = new TwoTuple<>("hello", 12);
        System.out.println("twoTuple = " + twoTuple);

        ThreeTuple<String, Integer, Double> threeTuple = new ThreeTuple<>("hello", 12, 1.1);
        System.out.println("threeTuple = " + threeTuple);
    }

    /**
     * 好方便的 util
     */
    @Test
    public void genericTupleTest() {
        System.out.println("Tuple.tuple(\"hello\",21) = " + Tuple.tuple("hello", 21));
        System.out.println("Tuple.tuple(22.3,\"world\",false) = " + Tuple.tuple(22.3, "world", false));
    }
}

class TwoTuple<A, B> {
    public final A first;
    public final B second;

    public TwoTuple(A first, B second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "TwoTuple{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}

class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
    public final C third;

    public ThreeTuple(A first, B second, C third) {
        super(first, second);
        this.third = third;
    }

    @Override
    public String toString() {
        return "ThreeTuple{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}