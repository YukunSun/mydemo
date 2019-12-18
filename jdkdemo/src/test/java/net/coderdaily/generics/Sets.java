package net.coderdaily.generics;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019/12/18 23:25
 * Blog: coderdaily.net
 */
public class Sets {
    public static <T> Set<T> union(Set<T> first, Set<T> second) {
        Set<T> result = new HashSet<>(first);
        result.addAll(second);
        return result;
    }

    public static <T> Set<T> intersection(Set<T> first, Set<T> second) {
        Set<T> result = new HashSet<>(first);
        result.retainAll(second);
        return result;
    }

    public static <T> Set<T> difference(Set<T> first, Set<T> second) {
        Set<T> result = new HashSet<>(first);
        result.removeAll(second);
        return result;
    }

    /**
     * 交集部分的补集
     *
     * @param first
     * @param second
     * @param <T>
     * @return
     */
    public static <T> Set<T> complement(Set<T> first, Set<T> second) {
        return difference(union(first, second), intersection(first, second));
    }
}
