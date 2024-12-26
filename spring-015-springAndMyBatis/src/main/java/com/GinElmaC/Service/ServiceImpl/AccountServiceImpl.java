package com.GinElmaC.Service.ServiceImpl;

import com.GinElmaC.Mapper.AccountMapper;
import com.GinElmaC.Pojo.Account;
import com.GinElmaC.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("accountSerivce")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public int save(Account account) {
        return accountMapper.insert(account);
    }

    @Override
    public int delectByActno(String actno) {
        return accountMapper.delectByActno(actno);
    }

    @Override
    public int modify(Account account) {
        return accountMapper.update(account);
    }

    @Override
    public Account getByActno(String actno) {
        return accountMapper.selectByActno(actno);
    }

    @Override
    public List<Account> getAll() {
        return accountMapper.selectAll();
    }

    @Override
    public void transfer(String fromActno, String toActno, double money) {
        Account accountFrom = accountMapper.selectByActno(fromActno);
        if(accountFrom.getBalance()<money){
            throw new RuntimeException("余额不足");
        }else{
            Account accountTo = accountMapper.selectByActno(toActno);
            accountFrom.setBalance(accountFrom.getBalance()-money);
            accountTo.setBalance(accountTo.getBalance()+money);
            int a = accountMapper.update(accountFrom);
            int b = accountMapper.update(accountTo);
            if(a+b != 2){
                throw new RuntimeException("未知错误转账失败，请联系银行");
            }
        }
    }
}
