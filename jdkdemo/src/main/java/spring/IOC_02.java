package spring;

/**
 * Author: sun.yukun@foxmail.com
 * Time: 2017/11/7 下午9:24
 * Blog: coderdaily.net
 */
public class IOC_02 {
    private UserService userService;


    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void getTheUser() {
        userService.selectTheUser();
    }

    public static void main(String[] args) {
        IOC_02 ioc_02 = new IOC_02();
        ioc_02.setUserService(new UserService("a"));
        ioc_02.getTheUser();
    }
}
