package com.example.demo.controller;

/**
 * @author : leilei
 * @date : 16:37 2020/2/16
 * @desc :
 */

import com.example.demo.entity.one.User;
import com.example.demo.entity.one.vo.CountUser;
import com.example.demo.entity.one.vo.MonthByUser;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("add")
    public String add(User user) {
        int i = userService.insertUser(user);
        if (i == 1) {
            return "success";
        }
        return "false";
    }

    @GetMapping("findAll")
    public List<User> findAll() {
        List<User> all = userService.findAll();
        if (all != null) {
            return all;
        }
        return null;
    }

    @GetMapping("countUserAge")
    public Integer countUserAge() {
        Integer ages = userService.countUserAge();
        return ages;
    }

    @GetMapping("countUserByMonth")
    public MonthByUser countUserByMonth(){
        MonthByUser monthByUser = userService.countUserByMonth();
        return monthByUser;
    }

    @GetMapping("countUser")
    public CountUser countUser(){
        CountUser countUser = userService.countUser();
        return countUser;
    }

}
