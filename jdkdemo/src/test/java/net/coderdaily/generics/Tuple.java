package net.coderdaily.generics;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019/12/18 23:12
 * Blog: coderdaily.net
 */
public class Tuple {
    public static <A, B> TwoTuple<A, B> tuple(A a, B b) {
        return new TwoTuple<>(a, b);
    }

    public static <A, B, C> ThreeTuple<A, B, C> tuple(A a, B b, C c) {
        return new ThreeTuple<>(a, b, c);
    }
}
