package com.GrowScanner.GrowScan.util;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.jndi.MongoClientFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
public class MongoConfig  {

@Primary
@Bean(name = "primary")
@ConfigurationProperties(prefix = "spring.mongodb1")
public MongoProperties getPrimary() {
    return new MongoProperties();
}
//@Bean(name = "secondary")
//@ConfigurationProperties(prefix = "spring.mongodb2")
//public MongoProperties getSecondary() {
//    return new MongoProperties();
//}
//
//@Bean(name = "ternary")
//@ConfigurationProperties(prefix = "spring.mongodb3")
//public MongoProperties getTernary() {
//    return new MongoProperties();
//}

@Primary
@Bean(name = "primaryMongoTemplate")
public MongoTemplate primaryMongoTemplate() throws Exception {
    return new MongoTemplate(primaryFactory(getPrimary()));
}

//@Bean(name = "secondaryMongoTemplate")
//public MongoTemplate secondaryMongoTemplate() throws Exception {
//    return new MongoTemplate(secondaryFactory(getSecondary()));
//}
//
//@Bean(name = "ternaryMongoTemplate")
//public MongoTemplate ternaryMongoTemplate() throws Exception {
//    return new MongoTemplate(ternaryFactory(getTernary()));
//}

@Bean
@Primary
public MongoDbFactory primaryFactory(final MongoProperties mongo) throws Exception {
	System.out.println(" primaryFactory........................."+mongo.getUri());
	MongoClientURI uri = new MongoClientURI(mongo.getUri());
    return new SimpleMongoDbFactory(new MongoClient(uri),
            mongo.getDatabase());
}

//@Bean
//public MongoDbFactory secondaryFactory(final MongoProperties mongo) throws Exception {
//	System.out.println("secondaryFactory........................."+mongo.getUri());
//	MongoClientURI uri = new MongoClientURI(mongo.getUri());
//    return new SimpleMongoDbFactory(new MongoClient(uri),
//            mongo.getDatabase());
//}
//
//@Bean
//public MongoDbFactory ternaryFactory(final MongoProperties mongo) throws Exception {
//	System.out.println("ternaryFactory........................."+mongo.getUri());
//	MongoClientURI uri = new MongoClientURI(mongo.getUri());
//    return new SimpleMongoDbFactory(new MongoClient(uri),
//            mongo.getDatabase());
//}
}
