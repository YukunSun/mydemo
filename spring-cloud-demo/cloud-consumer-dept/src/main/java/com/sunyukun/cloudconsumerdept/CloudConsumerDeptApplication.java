package com.sunyukun.cloudconsumerdept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
@EnableEurekaClient
public class CloudConsumerDeptApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerDeptApplication.class, args);
    }

    private static final RestTemplate restTemplate = new RestTemplate();
    public static final String PROVIDER = "http://localhost:8001/provider/";

    @RequestMapping(value = "ping")
    public String ping() {
        return "pong";
    }

    @GetMapping(value = "dept")
    public String getDept() {
        return restTemplate.getForObject(PROVIDER + "dept/list", String.class);
    }
}
