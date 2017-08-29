package net.coderdaily.dubbo.service;

public class DemoServiceImpl implements IDemoService {
    @Override
    public String sayHello(String name) {
        return "hello :" + name;
    }
}
