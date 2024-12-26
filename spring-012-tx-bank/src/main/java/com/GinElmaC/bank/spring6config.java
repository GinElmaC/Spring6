package com.GinElmaC.bank;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration//表示代替spring.xml配置文件
@ComponentScan("com.GinElmaC.bank")//组件扫描
@EnableTransactionManagement//开启事务管理
public class spring6config {

    //spring框架看到Bean注解后会调用被标注的方法，返回值是一个java对象，这个对象会被纳入spring容器管理
    //返回的对象就是spring容器中的一个Bean
    //并且这个Bean的名字就是"dataSource"
    @Bean(name = "dataSource")
    public DruidDataSource getDataSource(){
        DruidDataSource dataSource=  new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring");
        dataSource.setUsername("root");
        dataSource.setPassword("1998229wang");
        return dataSource;
    }
    @Bean(name = "jdbcTemplate")
    public JdbcTemplate getJdbc(DataSource dataSource){//如果方法内有参数，则spring容器调用这个方法时会自动给我们传递过来一个dataSource对象。
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }
    @Bean(name = "txManager")
    public DataSourceTransactionManager gettxManage(DataSource dataSource){//同上
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

}
