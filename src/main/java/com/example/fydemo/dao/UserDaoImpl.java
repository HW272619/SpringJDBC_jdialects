package com.example.fydemo.dao;

import com.example.fydemo.conf.SourceConfig;
import com.example.fydemo.entity.ProduceClass;
import com.example.fydemo.entity.User;
import com.github.drinkjava2.jdialects.Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class UserDaoImpl implements  UserDao {
    @Autowired
    @Qualifier("secondJdbcTemplate")
    JdbcTemplate secondJdbcTemplate;


    @Override
    public List<User> findall() {
        List<User>   list = secondJdbcTemplate.query("SELECT  * FROM  users",new Object[]{},new BeanPropertyRowMapper<>(User.class));

        return list;

    }

    @Autowired
    SourceConfig sourceConfig;

    @Override
    public List<User> paging(int PageNumber,int pageSize) {
        DataSource dataSource = sourceConfig.secondDataSource();
        Dialect d = Dialect.guessDialect(dataSource);
        String result = d.pagin(PageNumber, pageSize, "select * from users "); //创建分页SQL
        System.out.println(result);
        List<User>   list = secondJdbcTemplate.query(result,new Object[]{},new BeanPropertyRowMapper<>(User.class));
        return list;
    }
}
