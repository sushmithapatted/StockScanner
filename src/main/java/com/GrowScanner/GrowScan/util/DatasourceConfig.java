package com.GrowScanner.GrowScan.util;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

public class DatasourceConfig {
	 @Bean(name = "jdbcTemplate2")
	 public JdbcTemplate jdbcTemplate2(@Qualifier("db2") DataSource ds) {
	  return new JdbcTemplate(ds);
	 }
}
