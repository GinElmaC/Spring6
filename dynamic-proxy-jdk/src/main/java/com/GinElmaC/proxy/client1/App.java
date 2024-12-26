package com.GinElmaC.proxy.client1;

import com.GinElmaC.proxy.Util1.MyProxyUtil;
import com.GinElmaC.proxy.service1.StudentDao;
import com.GinElmaC.proxy.service1.StudentDaoImpl;

public class App {
    public static void main(String[] args) {
        StudentDao studentDao = (StudentDao) MyProxyUtil.getProxy(new StudentDaoImpl());
        System.out.println(studentDao.getGrade());
        System.out.println(studentDao.getName());
    }
}
