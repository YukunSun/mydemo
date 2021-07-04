package net.coderdaily.stub;

import com.sunyukun.bean.UserAddress;
import com.sunyukun.service.UserService;

import java.util.List;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2021/7/4 15:00
 * Blog: sunyukun.com
 */
public class UserServiceStub implements UserService {

    private final UserService userService;

    //构造函数传入真正的远程代理对象；必须有这个有参构造器
    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("UserServiceStub...before invoke");
        return userService.getUserAddressList(userId);
    }
}
