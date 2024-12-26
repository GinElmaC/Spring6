package com.GinElmaC.Service;

import com.GinElmaC.Pojo.Account;

import java.util.List;

/**
 * 账户业务逻辑接口
 */
public interface AccountService {
    int save(Account account);
    int delectByActno(String actno);
    int modify(Account account);
    Account selectByActno(String actno);
    List<Account> selectAll();

    void transfer(String fromActno,String toActno,double money);
}
