package net.coderdaily.spring.cycle2;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2021/3/10 19:31
 * Blog: bengle.me
 * <p>
 */
public class ServiceA {
    private ServiceB serviceB;

    public ServiceA() {
        System.out.println("constructor of ServiceA");
    }

    public void setServiceB(ServiceB serviceB) {
        this.serviceB = serviceB;
        System.out.println("A set serviceB by setter");
    }
}
