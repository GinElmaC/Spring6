package com.GinElmaC.Bean;

public class UserService {
    private UserDao userDao;
    public void generate(){
        userDao.insert();
    }
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }
}
