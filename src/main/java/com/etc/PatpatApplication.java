package com.etc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.ect.dao")
@EnableTransactionManagement
@SpringBootApplication
public class PatpatApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatpatApplication.class, args);
	}
}
