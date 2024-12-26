package com.GinElmaC.Mapper;

import com.GinElmaC.Pojo.Account;

import java.util.List;

public interface AccountMapper {//该接口的实现类不需要写，是mybatis通过动态代理机制生成实现类

    /**
     * 新增账户
     * @param account
     * @return
     */
    int insert(Account account);

    /**
     * 通过账号删除账户
     * @param actno
     * @return
     */
    int delectByActno(String actno);

    /**
     * 改
     * @param account
     * @return
     */
    int update(Account account);

    /**
     * 通过账号查
     * @param actno
     * @return
     */
    Account selectByActno(String actno);

    /**
     * 查所有
     * @return
     */
    List<Account> selectAll();

}
