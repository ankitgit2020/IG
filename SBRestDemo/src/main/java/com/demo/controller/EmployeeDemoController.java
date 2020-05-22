package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.EmployeeService;

@RestController
public class EmployeeDemoController {
	
	@Autowired
	@Qualifier("employeeService")
	EmployeeService employeeService1;
	
	@RequestMapping("/employees")
    public String getEmployees() 
    {
		System.out.println("Inside Employee");
        return employeeService1.getEmployee();
    }

}
