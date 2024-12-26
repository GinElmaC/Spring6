package com.GinElmaC.Mapper;

import com.GinElmaC.Pojo.Account;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Account的CRUD操作的Mapper，没有任何业务代码
 */
public interface AccountMapper {
    /**
     * 增加新账户
     * @param account
     * @return
     */
    int insert(Account account);

    /**
     * 根据账号删除账户
     * @param actno
     * @return
     */
    int delectByActno(String actno);

    /**
     * 将传入的Account对象更新到数据库中
     * @param account
     * @return
     */
    int update(Account account);

    /**
     * 根据账号查询
     * @param actno
     * @return
     */
    Account selectByActno(String actno);

    /**
     * 查询数据库中所有
     * @return
     */
    List<Account> selectAll();
}
