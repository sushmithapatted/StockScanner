package com.GrowScanner.GrowScan.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = 
"com.GrowScanner.GrowScan.repository",
    mongoTemplateRef = "primaryMongoTemplate")
public class PrimaryMongoConfig {

}