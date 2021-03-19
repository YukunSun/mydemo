package net.coderdaily.spring.cycle2;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2021/3/10 19:32
 * Blog: bengle.me
 */
public class ServiceB {
    private ServiceA serviceA;

    public void setServiceA(ServiceA serviceA) {
        this.serviceA = serviceA;
        System.out.println("B set serviceA  by setter");
    }
}
