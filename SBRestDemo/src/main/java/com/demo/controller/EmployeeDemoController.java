package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.CityModel;
import com.demo.service.CityService;


@RestController
public class EmployeeDemoController {
	
	@Autowired
	@Qualifier("cityService")
	CityService cityService;
	
	@RequestMapping("/employees")
    public List<CityModel> getEmployees() 
    {
		System.out.println("Fetching all cities");
        return cityService.getCities();
    }

	@RequestMapping("/cities")
    public List<CityModel> getCities() 
    {
		System.out.println("Fetching all cities");
        return cityService.getCities();
    }
	
	//@RequestMapping("/city/{cityName}")
	@GetMapping(value = "/city/{cityName}")
    public Optional<CityModel> getCity(@PathVariable String cityName) 
    {
		System.out.println("Fetching city by ID " + cityName);
        return cityService.getCity(cityName);
    }
}
