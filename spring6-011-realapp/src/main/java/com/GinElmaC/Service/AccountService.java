package com.GinElmaC.Service;

import org.springframework.stereotype.Service;

@Service
public class AccountService {
    public void transfer() {
        System.out.println("银行账户正在转账");
    }

    public void drawback() {
        System.out.println("银行账户正在取款");

    }
}
