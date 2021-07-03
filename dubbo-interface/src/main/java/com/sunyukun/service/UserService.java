package com.sunyukun.service;


import com.sunyukun.bean.UserAddress;

import java.util.List;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2021/7/3 22:58
 * Blog: sunyukun.com
 */
public interface UserService {
    List<UserAddress> getUserAddressList(String userId);
}
