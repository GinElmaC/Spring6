package com.GinElmaC.Auto.Impl;

import com.GinElmaC.Auto.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Override
    public void insert() {
        System.out.println("数据库在插入");
    }
}
