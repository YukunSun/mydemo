package net.coderdaily.dubbo.service.impl;

import com.sunyukun.bean.UserAddress;
import com.sunyukun.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2021/7/4 14:30
 * Blog: sunyukun.com
 */
@DubboService(version = "2.0.0")
public class UserServiceImpl2 implements UserService {
    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        List<UserAddress> list = new ArrayList<>();
        list.add(new UserAddress(1, "ShangHai", "s1"));
        list.add(new UserAddress(2, "Beijing", "b1"));
        list.add(new UserAddress(3, "ShangBei", "sb"));
        list.add(new UserAddress(4, "ShangBei", "sb2"));
        return list;
    }
}
