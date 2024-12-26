package com.GinElmaC.Service;

import com.GinElmaC.Pojo.Account;

import java.util.List;

public interface AccountService {

    int save(Account account);

    int delectByActno(String actno);

    int modify(Account account);

    Account getByActno(String actno);

    List<Account> getAll();

    void transfer(String fromActno,String toActno,double money);

}
