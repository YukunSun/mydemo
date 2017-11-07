package 综合;

import java.util.Random;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/11/2 下午3:35
 * Blog: coderdaily.net
 */
public class Random_01 {
    public static void main(String[] args) {
        Random random = new Random(100);
        Random random2 = new Random(100);
        System.out.println(random.nextInt());
        System.out.println(random2.nextInt());

        System.out.println(random.nextDouble());
        System.out.println(random2.nextDouble());
        System.out.println("Math.random()======");

        System.out.println(Math.random());
        System.out.println(Math.random());
    }
}
