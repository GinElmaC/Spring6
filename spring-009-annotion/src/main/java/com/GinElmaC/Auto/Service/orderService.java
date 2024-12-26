package com.GinElmaC.Auto.Service;

import com.GinElmaC.Auto.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class orderService {
    @Autowired
    @Qualifier("orderDaoImpl")
    private OrderDao orderDao;
    public void service(){
        orderDao.insert();
    }
}
