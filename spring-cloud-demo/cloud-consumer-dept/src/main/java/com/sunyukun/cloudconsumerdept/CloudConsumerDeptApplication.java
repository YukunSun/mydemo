package com.sunyukun.cloudconsumerdept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class CloudConsumerDeptApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerDeptApplication.class, args);
    }

    @RequestMapping(value = "ping")
    public String ping() {
        return "pong";
    }
}
