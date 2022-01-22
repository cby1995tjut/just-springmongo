package com.myspringmongo.mymongo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoConfig {

    @Bean
    public MongoTemplate getMongoTemplate() {
        //this is test
        return new MongoTemplate(new SimpleMongoClientDatabaseFactory("mongodb://admin:admin@localhost:27017/davon01?authSource=admin"));
    }
}
