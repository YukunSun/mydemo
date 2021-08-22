package com.sunyukun.cloudprovidedept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableEurekaClient
public class CloudProvideDeptApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudProvideDeptApplication.class, args);
    }

    @RequestMapping(value = "ping")
    public String ping() {
        return "pong";
    }
}
