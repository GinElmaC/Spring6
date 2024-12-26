package com.GinElmaC.bank.Service.Impl;

import com.GinElmaC.bank.Dao.AccountDao;
import com.GinElmaC.bank.Pojo.Account;
import com.GinElmaC.bank.Service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.PropertyResolver;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Override
    @Transactional
    public void transfer(String fromActno, String toActno, double money) {
        Account fromAccount = accountDao.selectByActno(fromActno);
        if(fromAccount.getBalance()<money){
            throw new RuntimeException("余额不足");
        }else{
            Account toAccount = accountDao.selectByActno(toActno);

            fromAccount.setBalance(fromAccount.getBalance()-money);
            int a = accountDao.update(fromAccount);

            toAccount.setBalance(toAccount.getBalance()+money);
            int b = accountDao.update(toAccount);
            if(a+b != 2){
                throw new RuntimeException("转账失败，请联系银行");
            }
        }
    }
}
