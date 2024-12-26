package com.GinElmaC.proxy.service;

public class OrderServiceImpl implements OrderService{
    @Override
    public void insert() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("数据库添加");
    }

    @Override
    public void modity() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("数据库修改");
    }

    @Override
    public void delect() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("数据库删除");
    }

    @Override
    public String getName() {
        System.out.println("得到名字");
        return "张三";
    }
}
