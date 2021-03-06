package net.coderdaily;

import com.sunyukun.bean.UserAddress;
import com.sunyukun.service.IDemoService;
import com.sunyukun.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
//@ImportResource("consumer.xml")
@RestController
public class DubboConsumerApplication {

    @DubboReference(version = "1.0.0", url = "dubbo://127.0.0.1:20880")
    private IDemoService demoService;

    @DubboReference(version = "1.0.0", url = "dubbo://127.0.0.1:20880",timeout = 10000)
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class, args);
    }

    @RequestMapping("index")
    public String index() {
        String reslt = demoService.sayHello("i am consumer");
        return reslt;
    }

    @RequestMapping("address")
    public List<UserAddress> address() {
        List<UserAddress> reslt = userService.getUserAddressList("1");
        return reslt;
    }
}
