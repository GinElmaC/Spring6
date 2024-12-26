package com.GinElmaC.Service;

import com.GinElmaC.Dao.orderDao;

public class orderService {
    private orderDao orderDao;
    public void setOrderDao(orderDao orderDao){
        this.orderDao = orderDao;
    }

    /**
     * 生成订单的业务方法
     */
    public void generate(){
        orderDao.generate();
    }
}
