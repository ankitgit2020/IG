package com.poc.cloudgateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {//extends WebSecurityConfigurerAdapter {
 
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//         .anyRequest().authenticated()
//         .and()
//         .oauth2Login();
//    }
    
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().authenticated()
//          .and()
//          .oauth2Login()
//          .clientRegistrationRepository(clientRegistrationRepository())
//          .authorizedClientService(authorizedClientService());
//    }
     
//    @Bean
//    public OAuth2AuthorizedClientService authorizedClientService() {
//     
//        return new InMemoryOAuth2AuthorizedClientService(
//          clientRegistrationRepository());
//    }
}