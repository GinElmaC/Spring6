package com.GinElmaC.biz;

import org.springframework.stereotype.Service;

@Service
public class VipService {
    public void insert(){
        System.out.println("新增vip用户信息");
    }
    public void delect(){
        System.out.println("删除vip用户信息");
    }
    public void motify(){
        System.out.println("修改vip用户信息");
    }
    public void select(){
        System.out.println("查询vip用户信息");
    }
}
