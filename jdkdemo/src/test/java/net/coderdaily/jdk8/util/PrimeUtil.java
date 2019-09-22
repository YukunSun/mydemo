package net.coderdaily.jdk8.util;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019/9/22 22:16
 * Blog: coderdaily.net
 */
public class PrimeUtil {
    /**
     * 判断质数
     *
     * @param number
     * @return
     */
    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        int tmp = number;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (tmp % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(2));
        System.out.println(isPrime(4));
    }
}
