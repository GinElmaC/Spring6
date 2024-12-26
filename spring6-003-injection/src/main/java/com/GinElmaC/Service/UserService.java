package com.GinElmaC.Service;

import com.GinElmaC.Dao.UserDao;

public class UserService {
    private UserDao userDao;

    //使用set注入的话必须提供一个set方法，至少这个方法是以set三个字母开始的
    //spring容器会调用这个set方法，来给UserDao对象赋值
    //set方法内的参数不能随便写，因为这个方法是给spring参数调用的，所以要存入被set的对象
    //但是到这里还是不够，需要在spring.xml配置文件中配置，配置的name规则：set方法的方法名去掉set后将第一个字母小写
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    public void saveUser(){
        userDao.insertUser();
    }
}
