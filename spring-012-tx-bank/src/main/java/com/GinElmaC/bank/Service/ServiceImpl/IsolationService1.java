package com.GinElmaC.bank.Service.ServiceImpl;

import com.GinElmaC.bank.Dao.AccountDao;
import com.GinElmaC.bank.Pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service("i1")
public class IsolationService1 {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    //负责查询
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void selectByActno(String act){
        Account account = accountDao.selectByActno(act);
        System.out.println(account);
    }
}
