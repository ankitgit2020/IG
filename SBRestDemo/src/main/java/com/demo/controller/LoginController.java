package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {
	

	
	@RequestMapping("/login")
    public String getLoginPage() 
    {
		System.out.println("Inside login controller");
        return "login";
    }

	@PostMapping("/login")
    public String loginUser() 
    {
		System.out.println("Inside Post login controller");
        return "login";
    }
	
	
	
}
