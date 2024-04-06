package com.GrowScanner.GrowScan.util;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
public class MongoConfig  {

@Primary
@Bean(name = "primary")
@ConfigurationProperties(prefix = "spring.mongodb1")
public MongoProperties getPrimary() {
    return new MongoProperties();
}

@Primary
@Bean(name = "primaryMongoTemplate")
public MongoTemplate primaryMongoTemplate() throws Exception {
    return new MongoTemplate(primaryFactory(getPrimary()));
}

@Bean
@Primary
public MongoDbFactory primaryFactory(final MongoProperties mongo) throws Exception {
	System.out.println(" primaryFactory........................."+mongo.getUri());
	MongoClientURI uri = new MongoClientURI(mongo.getUri());
    return new SimpleMongoDbFactory(new MongoClient(uri),
            mongo.getDatabase());
}

}

