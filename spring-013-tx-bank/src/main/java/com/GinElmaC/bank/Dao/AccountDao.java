package com.GinElmaC.bank.Dao;

import com.GinElmaC.bank.Pojo.Account;

/**
 * 只负责Account的增删改
 */
public interface AccountDao {
    /**
     * 根据账号查
     * @param Actno
     * @return
     */
    Account selectByActno(String Actno);

    /**
     * 更新账号信息
     * @param account
     * @return
     */
    int update(Account account);

}
