package com.example.fydemo;

import com.example.fydemo.conf.Datasourses;
import com.example.fydemo.dao.ProduceClassDao;
import com.example.fydemo.dao.UserDao;
import com.example.fydemo.entity.ProduceClass;
import com.example.fydemo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class FydemoApplicationTests {
    @Autowired
    private ProduceClassDao produceClassDao;
    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
        List<ProduceClass> list = produceClassDao.findall();
        for (ProduceClass produceClass : list) {
            System.out.println(list);
        }
        System.out.println(list);
    }

    @Test//获取表中数据个数操作
    public void count() {
        List<ProduceClass> list = produceClassDao.find("ZYYLCL_ⅠFJ_ZJ");
        System.out.println(list);
    }

    @Test//获取表中数据个数操作
    public void insert() {
        ProduceClass produceClass = new ProduceClass();
        produceClass.setID("B2B293C024727E28E053020011ACBCCF");
        produceClass.setCODE("CJGX_2#GMB_BBWP1");
        produceClass.setR_DATE(new Date());
        produceClass.setCLASS("1");
        produceClass.setR_TIME("08:28:20");
        produceClass.setDATAVALUE1(null);
        produceClass.setDATAVALUE2(4233.02148);
        produceClass.setDECIDE(null);
        produceClass.setTYPE(null);
        produceClass.setPROPERTY(null);
        produceClass.setREPORT_NAME(null);
        produceClass.setCREATE_BY(null);
        produceClass.setCREATE_TIME(new Date());
        produceClass.setMODIFY_BY(null);
        produceClass.setMODIFY_TIME(new Date());
        produceClassDao.save(produceClass);

    }

    @Test
    public void delete() {
        int delete = produceClassDao.delete("CJGX_2#GMB_BBWP1");
        System.out.println(delete);
    }

    @Test
    public void selectuser() {
        List<User> userList = userDao.findall();
        System.out.println(userList);
    }
    @Autowired
    Datasourses datasourses;
    @Test
    public void getm() {
//        String driver_class_name = datasourses.getDriver_class_name();
//        System.out.println(driver_class_name);
        List<ProduceClass> paging = produceClassDao.paging();
        System.out.println(paging);
        List<User> paginguser = userDao.paging(1,5);
        System.out.println(paginguser);
    }


}
