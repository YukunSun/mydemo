package jvm;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/11/5 下午5:01
 * Blog: coderdaily.net
 */
public class Intern_01 {
    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
