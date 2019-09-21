package net.coderdaily.jdk8;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019/9/19 23:33
 * Blog: coderdaily.net
 */
public class FunctionalTest {
    /**
     * 理解注解 @FunctionalInterface
     */
    @FunctionalInterface
    public interface IntHandler {
        //只能有一个抽象方法
        void handler(int i);

        //java.lang.Object中的方法算作“实例方法”
        boolean equals(Object o);
    }

    public static void main(String[] args) {

    }
}
