package com.poc.cloudgateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.poc.cloudgateway.filter.ErrorFilter;
import com.poc.cloudgateway.filter.ZuulPostFilter;
import com.poc.cloudgateway.filter.ZuulPreFilterJWT;
import com.poc.cloudgateway.filter.ZuulRouteFilter;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableOAuth2Sso
public class CloudGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudGatewayServiceApplication.class, args);
	}
	
	@Bean
	public ZuulPreFilterJWT preFilter() {
	    return new ZuulPreFilterJWT();
	}
	@Bean
	public ZuulPostFilter postFilter() {
	    return new ZuulPostFilter();
	}
	@Bean
	public ErrorFilter errorFilter() {
	    return new ErrorFilter();
	}
	@Bean
	public ZuulRouteFilter routeFilter() {
	    return new ZuulRouteFilter();
	}
	

}
