package com.GinElmaC.dao.Impl;

import com.GinElmaC.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void delectbyId(Integer id) {
        System.out.println("正在删除");
    }
}
