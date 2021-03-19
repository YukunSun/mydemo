package net.coderdaily;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2018/3/1 下午3:15
 * Blog: coderdaily.net
 */
@SpringBootApplication
@RestController
public class RedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

    @RequestMapping("/")
    public String index() {
        return "hello redis";
    }
}
