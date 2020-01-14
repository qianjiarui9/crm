package com.briup.crm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.briup.crm.dao")
@SpringBootApplication
public class Crm2Application {

	public static void main(String[] args) {
		SpringApplication.run(Crm2Application.class, args);
	}

}
