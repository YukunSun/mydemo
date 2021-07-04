package net.coderdaily;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@ImportResource("provider.xml")
@RestController
public class DubboProviderApplication {
//    @Autowired
//    private IDemoService demoService;

    public static void main(String[] args) {
        SpringApplication.run(DubboProviderApplication.class, args);
    }

//    @RequestMapping("index")
//    public String index() {
//        String reslt = demoService.sayHello("i am provider");
//        return reslt;
//    }
}
