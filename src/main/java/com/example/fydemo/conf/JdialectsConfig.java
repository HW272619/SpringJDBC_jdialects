package com.example.fydemo.conf;

import com.github.drinkjava2.jdialects.Dialect;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JdialectsConfig {

    @Autowired
    Datasourses datasourses;


    //@Bean
    public DataSource dataSource1() {
        HikariDataSource ds=new HikariDataSource();
        ds.setDriverClassName(datasourses.getDriver_class_name());
        ds.setJdbcUrl(ds.getJdbcUrl());
        ds.setUsername(ds.getUsername());
        ds.setPassword(ds.getPassword());
        return ds;
    }

}
