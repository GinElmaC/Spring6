package com.GinElmaC.service.Impl;

import com.GinElmaC.dao.Impl.UserDaoImpl;
import com.GinElmaC.dao.UserDao;
import com.GinElmaC.service.UserService;

public class UserServiceImpl implements UserService {
    //因为在以后得业务中往往也需要用到这个持久层多态对象，所以可以设置成成员变量
    private UserDao userDao = new UserDaoImpl();
    @Override
    public void deletUser(Integer id) {
        userDao.delectbyId(1);
    }
}
