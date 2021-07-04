package net.coderdaily.dubbo.service.impl;


import com.sunyukun.bean.UserAddress;
import com.sunyukun.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2021/7/3 23:04
 * Blog: sunyukun.com
 */
@DubboService(version = "1.0.0")
public class UserServiceImpl implements UserService {
    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        List<UserAddress> list = new ArrayList<>();
        list.add(new UserAddress(1, "ShangHai", "s1"));
        list.add(new UserAddress(2, "Beijing", "b1"));
        list.add(new UserAddress(3, "ShangBei", "sb"));
        return list;
    }
}
