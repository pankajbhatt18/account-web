package com.web.account;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

/**
 * The Class AccountApplication.
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.web.account", "com.web.account.controller", "com.web.account" })
@EnableJpaRepositories(basePackages = { "com.web.account" })
@EntityScan(basePackages = { "com.web.account.entity", "com.web.account.model" })
@OpenAPIDefinition(info = @Info(title = "Account/Login MS", version = "1.0.0", description = "Account/Login for performing account/login related queries"))
public class AccountApplication {
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}
}
