package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.RoleModel;

@Repository
public interface RoleDao extends JpaRepository<RoleModel, Integer> {
	
	RoleModel findByAuthority(String role);
	//RoleModel findByRole(String role);

}