package com.web.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    //@Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//	
//	public WebSecurityConfiguration(BCryptPasswordEncoder bCryptPasswordEncoder) {
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }



    

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//                auth
//                    .userDetailsService(userDetailsService);
//                    //.passwordEncoder(bCryptPasswordEncoder);
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        	.antMatchers("/welcome/**").permitAll()// anyone can access /quests/**
            .antMatchers("/admin/**").hasRole("ADMIN")//ADMIN role can access /admin/**           
            .anyRequest().authenticated().and().csrf().disable()
            .formLogin();//enable spring default form login;

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }
    
    
    public void configureGlobal(AuthenticationManagerBuilder auth) 
      throws Exception {
        auth.inMemoryAuthentication().withUser("user")
          .password("{noop}password").roles("USER");
    }
    

}