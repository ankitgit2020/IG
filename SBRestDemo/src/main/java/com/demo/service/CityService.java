package com.demo.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.dao.CityDao;
import com.demo.model.CityModel;

@Component
public class CityService {
	
	@Autowired
	CityDao cityDao;

	public CityService()throws IOException {
		
	}
	public List<CityModel> getCities() {
		
		//return "Hello from service";
		return cityDao.findAll();
	}
	
	public Optional<CityModel> getCity(String cityName) {
		
		//return "Hello from service";
		System.out.println("Fetching city by ID: " + cityName);
		
		return cityDao.getCityByName(cityName);
	}
	
	
}
