package com.GinElmaC.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void login(){
        System.out.println("正在登录");
    }

    public void logout(){
        System.out.println("退出登录");
    }
}
