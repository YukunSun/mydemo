package com.sunyukun.cloudprovidedept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "dept/discovery")
    public String deptDiscovery() {
        List<String> services = discoveryClient.getServices();
        for (String svc : services) {
            List<ServiceInstance> instances = discoveryClient.getInstances(svc);
            for (ServiceInstance ins : instances) {
                System.out.println("ins = " + ins);
            }
        }
        return String.join(",", services);
    }
}
