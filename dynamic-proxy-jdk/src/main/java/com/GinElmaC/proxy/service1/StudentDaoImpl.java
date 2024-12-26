package com.GinElmaC.proxy.service1;

public class StudentDaoImpl implements StudentDao{
    @Override
    public String getName() {
        System.out.println("获取名字");
        return "张三";
    }

    @Override
    public int getGrade() {
        System.out.println("获取成绩");
        return 100;
    }
}
