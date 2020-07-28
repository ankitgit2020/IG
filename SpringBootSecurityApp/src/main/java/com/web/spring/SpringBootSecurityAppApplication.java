package com.web.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSecurityAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityAppApplication.class, args);
		System.out.println("System is running on port 8180");
	}

}
