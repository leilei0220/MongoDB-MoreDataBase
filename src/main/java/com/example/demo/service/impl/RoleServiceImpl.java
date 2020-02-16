package com.example.demo.service.impl;

import com.example.demo.entity.two.Role;
import com.example.demo.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author : leilei
 * @date : 16:18 2020/2/16
 * @desc :
 */
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    @Qualifier("twoMongo")
    private MongoTemplate twoMongoTemplate;

    @Override
    public int insertRole(Role role) {
        role.setCreatTime(LocalDateTime.now());
        try {
            twoMongoTemplate.insert(role);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
