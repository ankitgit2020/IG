package com.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootConfiguration
public class SbRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbRestDemoApplication.class, args);
		//ApplicationContext ctx = SpringApplication.run(ApplicationContext.class, args);
	}

}
