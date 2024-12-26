package com.GinElmaC.Service;

import com.GinElmaC.Dao.UserDao;
import com.GinElmaC.Dao.VipDao;

public class CustomerService {
    private UserDao userDao;
    private VipDao vipDao;

    public CustomerService(UserDao userDao,VipDao vipDao){
        this.userDao = userDao;
        this.vipDao = vipDao;
    }

    public CustomerService() {
    }

    /**
     * 获取
     * @return userDao
     */
    public UserDao getUserDao() {
        return userDao;
    }

    /**
     * 设置
     * @param userDao
     */
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 获取
     * @return vipDao
     */
    public VipDao getVipDao() {
        return vipDao;
    }

    /**
     * 设置
     * @param vipDao
     */
    public void setVipDao(VipDao vipDao) {
        this.vipDao = vipDao;
    }

    public String toString() {
        return "CustomerService{userDao = " + userDao + ", vipDao = " + vipDao + "}";
    }
}
