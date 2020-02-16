package com.example.demo.service;

import com.example.demo.entity.one.User;
import com.example.demo.entity.one.vo.CountUser;
import com.example.demo.entity.one.vo.MonthByUser;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author : leilei
 * @date : 16:17 2020/2/16
 * @desc :
 */
public interface IUserService {

    int insertUser(User user);

    List<User> findAll();

    Integer countUserAge();

    MonthByUser countUserByMonth();

    CountUser countUser();

}

