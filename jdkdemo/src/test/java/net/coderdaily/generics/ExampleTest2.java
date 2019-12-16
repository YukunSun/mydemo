package net.coderdaily.generics;

import net.coderdaily.jdk8.util.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019/12/15 23:03
 * Blog: coderdaily.net
 * <p>
 * 演示：用在方法上
 */
public class ExampleTest2 {


    /**
     * 你说气不气人，啥都能接收😄
     */
    @Test
    public void genericTest1() {
        GenericMethods methods = new GenericMethods();
        methods.f("hello");
        methods.f(2);
        methods.f(2.3);
        methods.f('a');
        methods.f(methods);
    }

    @Test
    public void test2() {
        Map<String, Integer> map = New.map();
        System.out.println("map = " + map);
        List<String> list = New.list();
        System.out.println("list = " + list);

        //FIXME：与书不一样，java8改进了？
        New.fun(New.map());
        New.<User, List<Test>>fun(New.map());
    }
}

class New {
    public static <K, V> Map<K, V> map() {
        return new HashMap<>();
    }

    public static <T> List<T> list() {
        return new ArrayList<>();
    }

    static void fun(Map<User, List<? extends Test>> map) {
        System.out.println("map = " + map);
    }
}


class GenericMethods {
    public <T> void f(T t) {
        System.out.println("t = " + t);
    }
}