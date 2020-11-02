package com.example.fydemo.dao;

import com.example.fydemo.entity.ProduceClass;

import java.util.List;
import java.util.Map;

public interface ProduceClassDao {
    int save(ProduceClass produceClass);

    int delete(String Code);

    List<ProduceClass> find(String Code);

    int modify(String CLASS, String CODE);

    List<ProduceClass>   findall();

    List<ProduceClass>  paging();

}
