package com.jk.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.util.ArrayList;
import java.util.List;

public class MongoConfig {
    @Bean
    public MongoClient mongoClient(){
        String host = "127.0.0.1";
        Integer port = 27017;
        ServerAddress serverAddress = new ServerAddress(host,port);
        List<MongoCredential> mongoCredentialList = new ArrayList<>();
        return new MongoClient(serverAddress,mongoCredentialList);
    }
    @Bean
    public MongoDbFactory mongoDbFactory(){
        String database = "medicine";
        return new SimpleMongoDbFactory(mongoClient(),database);
    }

    @Bean
    public MongoTemplate mongoTemplate(){
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;
    }
}
