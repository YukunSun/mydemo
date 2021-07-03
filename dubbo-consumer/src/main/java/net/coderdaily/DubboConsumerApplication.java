package net.coderdaily;

import com.sunyukun.bean.UserAddress;
import com.sunyukun.service.IDemoService;
import com.sunyukun.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@SpringBootApplication
@ImportResource("consumer.xml")
@RestController
public class DubboConsumerApplication {

    @Resource
    private IDemoService demoService;
//    @Resource
//    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class, args);
    }

    @RequestMapping("index")
    public String index() {
        String reslt = demoService.sayHello("i am consumer");
        return reslt;
    }

//    @RequestMapping("address")
//    public List<UserAddress> address() {
//        List<UserAddress> reslt = userService.getUserAddressList("1");
//        return reslt;
//    }
}
