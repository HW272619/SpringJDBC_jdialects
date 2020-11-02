package com.example.fydemo.dao;

import com.example.fydemo.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findall();
    List<User> paging(int PageNumber,int pageSize);
}
