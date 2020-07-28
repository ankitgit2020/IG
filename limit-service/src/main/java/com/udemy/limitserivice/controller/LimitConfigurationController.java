package com.udemy.limitserivice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.limitserivice.config.Configuration;
import com.udemy.limitserivice.model.LimitConfiguration;

@RestController
public class LimitConfigurationController {
	
	@Autowired
	Configuration config;
	
	@GetMapping("/limit")
	public LimitConfiguration retreiveLimitConfiguration() {
		
		return new LimitConfiguration(config.getMaximum(),config.getMinimum());
		
	}

}
