package com.GinElmaC.re.Impl;

import org.springframework.stereotype.Repository;

@Repository("studentDao")
public class StudentDao implements com.GinElmaC.re.dao.StudentDao {
    @Override
    public void insert() {
        System.out.println("新增Student数据");
    }
}
