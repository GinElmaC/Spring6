package com.GinElmaC.Service;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public void generate() {
        System.out.println("正在生成订单");
        if(1==1){
            throw new RuntimeException("订单异常");
        }
    }

    public void cancel() {
        System.out.println("订单已取消");
    }
}
