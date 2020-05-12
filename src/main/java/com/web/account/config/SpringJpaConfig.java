//package com.web.account.config;
//
//import java.sql.SQLException;
//
//import javax.sql.DataSource;
//
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//
//    @Configuration
//	@ConfigurationProperties(prefix = "spring.datasource")
//    @EntityScan(basePackages = {"com.web.account.entity"})
//	public class SpringJpaConfig extends HikariConfig {
//
//	    @Bean
//	    public DataSource dataSource() throws SQLException {
//	        return new HikariDataSource(this);
//	    }
//
//	}
