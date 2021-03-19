package net.coderdaily.spring.cycle1;

import org.springframework.stereotype.Component;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2021/3/10 19:32
 * Blog: bengle.me
 */
@Component(value = "c1serviceB")
public class ServiceB {
    private ServiceA serviceA;

    public ServiceB(ServiceA serviceA) {
        this.serviceA = serviceA;
    }
}
