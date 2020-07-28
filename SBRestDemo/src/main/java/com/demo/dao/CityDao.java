package com.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.model.CityModel;

@Repository
public interface CityDao extends JpaRepository<CityModel,Long>{
	
	@Query("SELECT t FROM CityModel t where t.name = ?1") 
	public Optional<CityModel> getCityByName(String cityName);

}
