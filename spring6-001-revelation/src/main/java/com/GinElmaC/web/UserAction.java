package com.GinElmaC.web;

import com.GinElmaC.service.Impl.UserServiceImpl;
import com.GinElmaC.service.UserService;

/**
 * 表示层
 * 表示层调用业务层，业务层调用接口层
 */
public class UserAction {
    private UserService userService = new UserServiceImpl();

    public void deleteUserquest(){
        userService.deletUser(1);
    }
}
