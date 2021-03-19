package net.coderdaily.spring.bean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2021/3/20 00:42
 * Blog: bengle.me
 * <p>
 * 演示bean的生命周期
 */
public class BeanLifeMain {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationProperties.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationProperties.xml");
        User user = context.getBean("user", User.class);
        System.out.println("step4:获取bean,user = " + user);
        context.close();
    }
}
