package com.GinElmaC.biz;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void insert(){
        System.out.println("新增用户信息");
    }
    public void delect(){
        System.out.println("删除用户信息");
    }
    public void motify(){
        System.out.println("修改用户信息");
    }
    public void select(){
        System.out.println("查询用户信息");
    }
}
