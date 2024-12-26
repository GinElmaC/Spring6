package com.GinElmaC.bank.Dao.DaoImpl;


import com.GinElmaC.bank.Dao.AccountDao;
import com.GinElmaC.bank.Pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account selectByActno(String Actno) {
        String sql = "select actno,balance from t_act where actno = ?";
        Account account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), Actno);
        return account;
    }

    @Override
    public int update(Account account) {
        String sql = "update t_act set balance = ? where actno = ?";
        int count = jdbcTemplate.update(sql,account.getBalance(),account.getActno());
        return count;
    }

    @Override
    public int insert(Account account) {
        String sql = "insert into t_act values(?,?)";
        return jdbcTemplate.update(sql,account.getActno(),account.getBalance());
    }
}
