package com.GinElmaC.bank.Service.ServiceImpl;

import com.GinElmaC.bank.Dao.AccountDao;
import com.GinElmaC.bank.Pojo.Account;
import com.GinElmaC.bank.Service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.PropertyResolver;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Resource(name = "accountDao")
    private AccountDao accountDao;
    @Autowired
    private PropertyResolver propertyResolver;
    @Autowired
    private AccountService accountService2;


    @Override
    //写在方法上就代表支对这个方法进行事务管理，写在类上表示对这类所有方法控制
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
//            b = 0;
            if(a+b != 2){
                throw new RuntimeException("转账失败，请联系银行");
            }
        }
    }
    @Resource(name = "accountService2")
    private AccountService accountService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Account account) {
        accountDao.insert(account);

        Account account1 = new Account("act-004",20000.00);
        try {
            accountService2.save(account1);
        } catch (Exception e) {
            System.out.println("自制错误");
        }
    }
}
