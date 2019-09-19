package net.coderdaily.jdk8;

import java.util.Arrays;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019/9/19 23:03
 * Blog: coderdaily.net
 */
public class Declarative {

    /**
     * 命令式编程：定义好一些变量等，要一步步执行
     */
    public static void imperative() {
        int[] arr = {1, 2, 3, 5, 6, 7};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 申明式编程：一步一步该干什么
     */
    public static void declarative() {
        int[] arr = {1, 2, 3, 5, 6, 7};
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void main(String[] args) {
        imperative();
        declarative();
    }
}
