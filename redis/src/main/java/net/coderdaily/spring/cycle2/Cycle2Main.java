package net.coderdaily.spring.cycle2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2021/3/19 19:21
 * Blog: bengle.me
 */
public class Cycle2Main {
    public static void main(String[] args) {
        //如果applicationProperties.xml设置成scope=singleton可以创建成功；但是设置成scope=prototype就会报错（Is there an unresolvable circular reference）
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationProperties.xml");
        ServiceA a = context.getBean("a", ServiceA.class);
        ServiceB b = context.getBean("b", ServiceB.class);
    }
}
