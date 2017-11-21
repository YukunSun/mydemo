package 包装类;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/11/16 下午9:13
 * Blog: coderdaily.net
 */
public class Integer_01 {
    public static void main(String[] args) {
        Integer a1 = 1;
        Integer a2 = 1;
        System.out.println(a1 == a2);//true

        Integer b1 = 128;
        Integer b2 = 128;
        System.out.println(b1 == b2);//false
    }
}