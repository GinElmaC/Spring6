package com.GinElmaC.bank.Service;

import com.GinElmaC.bank.Pojo.Account;

/**
 * 业务接口
 */
public interface AccountService {
    void transfer(String fromActno,String toActno,double money);

    void save(Account account);
}
