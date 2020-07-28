package com.demo.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.dao.RoleDao;
import com.demo.dao.UserDao;
import com.demo.model.RoleModel;
import com.demo.model.UserModel;

@Service
public class UserService {

    private UserDao UserDao;
    private RoleDao RoleDao;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserDao UserDao,
                       RoleDao RoleDao,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.UserDao = UserDao;
        this.RoleDao = RoleDao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public UserModel findUserByEmail(String userName) {
        return UserDao.findByUserName(userName);
    	//return null;
    }

    public UserModel findUserByUserName(String UserModelName) {
        return UserDao.findByUserName(UserModelName);
    }

    public UserModel saveUserModel(UserModel UserModel) {
        UserModel.setPassword(bCryptPasswordEncoder.encode(UserModel.getPassword()));
        UserModel.setEnabled(true);
        RoleModel UserModelRoleModel = RoleDao.findByAuthority("ADMIN");
        UserModel.setRoles(new HashSet<RoleModel>(Arrays.asList(UserModelRoleModel)));
        return UserDao.save(UserModel);
    }

}