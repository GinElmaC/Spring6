package com.GinElmaC.bank.Service.ServiceImpl;

import com.GinElmaC.bank.Dao.AccountDao;
import com.GinElmaC.bank.Pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service("i2")
public class IsolationService2 {
    @Resource(name = "accountDao")
    private AccountDao accountDao;

    //负责insert
//    @Transactional(rollbackFor = RuntimeException.class)//表示发生RuntimeException异常及其子类异常都回滚
    @Transactional(noRollbackFor = NullPointerException.class)//表示发生空指针异常不回滚，其他回滚
    public void save(Account act){
        accountDao.insert(act);

    }
}
