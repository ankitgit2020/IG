package com.poc.cloudgateway;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
public class CloudGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudGatewayServiceApplication.class, args);
	}

//  @Bean	
//	public RouteLocator customRouteLocator(RouteLocatorBuilder builder, 
//			TokenRelayGatewayFilterFactory tokenRelay) {
//	
//		return builder.routes()
//				.route("servlet-app", r -> r.path("/movie-info-service", "/rating-data-service")
//				.filters(f -> f.filter(tokenRelay.apply()))
//				.uri("http://localhost:8000"))
//				.build();
//
//	}
	
  
  @GetMapping("/")
	public String message(Principal principal) {
		return "Hi Gateway app "+principal.getName()+" welcome to SpringCloudOauth2ExampleApplication";
	}
	
}
