package net.coderdaily.dubbo.service.impl;

import com.sunyukun.service.IDemoService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(version = "1.0.0")
public class DemoServiceImpl implements IDemoService {
    @Override
    public String sayHello(String name) {
        return "hello :" + name;
    }
}
