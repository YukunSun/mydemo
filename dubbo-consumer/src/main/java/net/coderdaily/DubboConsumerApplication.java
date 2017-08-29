package net.coderdaily;

import net.coderdaily.dubbo.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ImportResource("consumer.xml")
@RestController
public class DubboConsumerApplication {

    @Autowired
    private IDemoService demoService;

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class, args);
    }

    @RequestMapping("index")
    public String index() {
        String reslt = demoService.sayHello("i am consumer");
        return reslt;
    }
}
