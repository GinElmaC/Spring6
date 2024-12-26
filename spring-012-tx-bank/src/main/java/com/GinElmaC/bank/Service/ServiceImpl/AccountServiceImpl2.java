package com.GinElmaC.bank.Service.ServiceImpl;

import com.GinElmaC.bank.Dao.AccountDao;
import com.GinElmaC.bank.Pojo.Account;
import com.GinElmaC.bank.Service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService2")
public class AccountServiceImpl2 implements AccountService {
    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Override
    public void transfer(String fromActno, String toActno, double money) {

    }


    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(Account account) {
        accountDao.insert(account);
        if(1==1){
            throw new RuntimeException("111");
        }
    }
}
