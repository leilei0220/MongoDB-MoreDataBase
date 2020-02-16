package com.example.demo.service.impl;

import com.example.demo.entity.one.User;
import com.example.demo.entity.three.Student;
import com.example.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author : leilei
 * @date : 16:17 2020/2/16
 * @desc :
 */
@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    @Qualifier("threeMongo")
    private MongoTemplate threeMongoTemplate;

    @Autowired
    @Qualifier("oneMongo")
    private MongoTemplate oneMongoTemplate;


    @Override
    public int insertStudent(Student student) {
        LocalDateTime now = LocalDateTime.now();
        student.setCreatTime(now);
        try {
            threeMongoTemplate.insert(student);
            oneMongoTemplate.insert(
                    User.builder()
                            .id(student.getId())
                            .userName(student.getStudentName())
                            .age(student.getAge())
                            .creatTime(now)
                            .sex(new User().getSex())
                            .build());
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
