package net.coderdaily.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2021/3/20 01:01
 * Blog: bengle.me
 */
public class MyAllBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("在Bean初始化之前执行的方法");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("在Bean初始化之后执行的方法");
        return bean;
    }
}
