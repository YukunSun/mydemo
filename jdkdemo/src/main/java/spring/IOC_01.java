package spring;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/11/7 下午9:12
 * Blog: coderdaily.net
 */
public class IOC_01 {
    private UserService userService;

    public IOC_01(UserService userService) {
        this.userService = userService;
    }

    public void getTheUser() {
        userService.selectTheUser();
    }

    //使用者
    public static void main(String[] args) {
        IOC_01 ioc01 = new IOC_01(new UserService("a"));
        ioc01.getTheUser();
    }
}
