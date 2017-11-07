package spring;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/11/7 下午9:31
 * Blog: coderdaily.net
 */
public class IOC_03 implements IPrintService {
    private UserService userService;

    public void injectUserService(UserService userService) {
        this.userService = userService;
    }

    public void getTheUser() {
        userService.selectTheUser();
    }

    public static void main(String[] args) {
        IOC_03 ioc03 = new IOC_03();
        ioc03.injectUserService(new UserService("a"));
        ioc03.getTheUser();
    }
}
