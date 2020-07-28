package com.web.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/welcome")
	public String welcome(Model model) {
		
		model.addAttribute("name", "Welcome Page");
		model.addAttribute("desc", "Unsecured Page");
		
		return "home";
	}
	
	@RequestMapping("/profile")
	public String profile(Model model) {
		
		model.addAttribute("name", "Profile Page");
		model.addAttribute("desc", "Secured Page");
		
		return "profile";
	}
}
