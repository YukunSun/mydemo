package net.coderdaily.dubbo.service.impl;

import com.sunyukun.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2021/7/4 06:37
 * Blog: sunyukun.com
 */
public class DemoServiceImpl implements IDemoService {
    @Autowired
    private IDemoService demoService;

    @Override
    public String sayHello(String name) {
        return demoService.sayHello("111");
    }
}
