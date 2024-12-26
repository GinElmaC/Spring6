package com.GinElmaC.Service.ServiceImpl;

import com.GinElmaC.Mapper.AccountMapper;
import com.GinElmaC.Pojo.Account;
import com.GinElmaC.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("accountService")
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
    public Account selectByActno(String actno) {
        return accountMapper.selectByActno(actno);
    }

    @Override
    public List<Account> selectAll() {
        return accountMapper.selectAll();
    }

    @Override
    public void transfer(String fromActno, String toActno, double money) {
        Account fromAccount = accountMapper.selectByActno(fromActno);
        if(fromAccount.getBalance()<money){
            throw new RuntimeException("余额不足");
        }else{
            Account toAccount = accountMapper.selectByActno(toActno);
            fromAccount.setBalance(fromAccount.getBalance()-money);
            toAccount.setBalance(toAccount.getBalance()+money);
            int a = accountMapper.update(fromAccount);
            int b = accountMapper.update(toAccount);
            if(a+b != 2){
                throw new RuntimeException("未知错误，请联系银行");
            }
        }
    }
}
