package net.coderdaily.spring;

import org.springframework.stereotype.Component;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2021/3/10 19:32
 * Blog: bengle.me
 */
@Component
public class ServiceB {
    private ServiceA serviceA;

    public ServiceB(ServiceA serviceA) {
        this.serviceA = serviceA;
    }
}
