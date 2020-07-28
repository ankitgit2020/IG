package com.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.UserModel;

@Repository
public interface UserDao extends JpaRepository<UserModel, Long> {
	//UserModel findByEmail(String email);
	UserModel findByUserName(String userName);
}