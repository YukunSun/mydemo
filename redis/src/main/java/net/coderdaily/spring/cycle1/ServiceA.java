package net.coderdaily.spring.cycle1;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2021/3/10 19:31
 * Blog: bengle.me
 * <p>
 * 构造函数创建，解决不了这个循环依赖，就像一个鸡生蛋的问题；
 * 这里显式指定了要用构造器的方法来构造bean
 */
@Component(value = "c1serviceA")
public class ServiceA {
    private ServiceB serviceB;

    public ServiceA(ServiceB serviceB) {
        this.serviceB = serviceB;
    }
}
