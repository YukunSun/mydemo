package net.coderdaily.generics;

import org.junit.Test;

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
}

class GenericMethods {
    public <T> void f(T t) {
        System.out.println("t = " + t);
    }
}