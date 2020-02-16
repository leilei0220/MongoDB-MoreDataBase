package com.example.demo.config;

import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author : leilei
 * @date : 16:03 2020/2/16
 * @desc : monngo第一个数据源
 */
@Configuration
@EnableMongoRepositories(
        basePackages = "com.example.demo.entity.one",
        mongoTemplateRef = "oneMongo")
public class OneMongoMongoTemplate {

    @Autowired
    @Qualifier("oneMongoProperties")
    private MongoProperties mongoProperties;

    @Primary
    @Bean(name = "oneMongo") //第一个数据源名字oneMongo
    public MongoTemplate statisMongoTemplate() throws Exception {
        return new MongoTemplate(statisFactory(this.mongoProperties));
    }

    @Bean
    @Primary
    public MongoDbFactory statisFactory(MongoProperties mongoProperties) throws Exception {
        return new SimpleMongoDbFactory(new MongoClientURI(mongoProperties.getUri()));
    }
}

