package com.GinElmaC.Dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

    public UserDao(){
        logger.info("普通用户构造方法");
    }

    public void insertUser(){
        logger.info("数据库正在保存");
    }
}
