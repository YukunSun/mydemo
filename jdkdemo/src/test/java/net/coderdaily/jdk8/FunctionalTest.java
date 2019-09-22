package net.coderdaily.jdk8;

import net.coderdaily.jdk8.util.User;
import org.junit.Test;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019/9/19 23:33
 * Blog: coderdaily.net
 */
public class FunctionalTest {
    /**
     * 例1：理解注解 @FunctionalInterface
     */
    @FunctionalInterface
    public interface IntHandler {
        //只能有一个抽象方法
        void handler(int i);

        //java.lang.Object中的方法算作“实例方法”
        boolean equals(Object o);
    }


    //例2：UserFactory 是 User 的工厂类，是一个函数式接口
    //这里的 User显然是有两个构造函数的，难道是根据参数类型区别出来的？？？
    static UserFactory<User> uf = User::new;

    @FunctionalInterface
    interface UserFactory<U extends User> {
        U create(String name, Integer age);
    }

    @Test
    public void f2() {
        User u = uf.create("foo", 12);
        System.out.printf(u.toString());
    }
}
