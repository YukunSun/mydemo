package rtti;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/11/25 下午11:09
 * Blog: coderdaily.net
 */
public class Reference_05 {
    public static void main(String[] args) {
        String v = new String("abc");
        f(v);
        System.out.println(v);
    }

    private static void f(String v) {
        v = "cde";
    }
}