package net.coderdaily.dubbo.service.impl;

import com.sunyukun.service.IDemoService;

public class DemoServiceImpl implements IDemoService {
    @Override
    public String sayHello(String name) {
        return "hello :" + name;
    }
}
