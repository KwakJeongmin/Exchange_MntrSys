package com.project.ex_mntr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ExchangeMntrSysApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExchangeMntrSysApplication.class, args);
	}

}
