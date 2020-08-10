package com.poc.resourceserver;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableOAuth2Sso
@RestController
public class DemoResourceServerApplication {
	
	@GetMapping("/")
	public String message(Principal principal) {
		return "Hi "+principal.getName()+" welcome to SpringCloudOauth2ExampleApplication";
	}

	
	public static void main(String[] args) {
		SpringApplication.run(DemoResourceServerApplication.class, args);
	}
	
	

}
