package com.GrowScanner.GrowScan.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@EnableMongoRepositories(basePackages = 
"com.GrowScanner.GrowScanner.repository",
    mongoTemplateRef = "primaryMongoTemplate")
public class PrimaryMongoConfig extends AbstractMongoClientConfiguration {
	
	  @Value("${spring.data.mongodb.uri}")
	    private String mongoUrl;
	  
	@Override
    protected String getDatabaseName() {
        return "stock_seeker";
    }

    @Override
    public MongoClient mongoClient() {
        return MongoClients.create(mongoUrl); 
    }
   
}
