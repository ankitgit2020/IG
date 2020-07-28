package com.demo.service;
import com.demo.model.RoleModel;
import com.demo.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;
    
    
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserModel user = userService.findUserByUserName(userName);
        if(user == null){
        	System.out.println("No user found with username: " + userName);
            throw new UsernameNotFoundException("User not found.");
        }
        List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
        authorities.forEach(i -> System.out.println(i.getAuthority()));;
        return buildUserForAuthentication(user, authorities);
    }

    private List<GrantedAuthority> getUserAuthority(Set<RoleModel> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        for (RoleModel role : userRoles) {
            roles.add(new SimpleGrantedAuthority(role.getAuthority()));
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }

    private UserDetails buildUserForAuthentication(UserModel user, List<GrantedAuthority> authorities) {
    	
    	System.out.println("Inside buildUserForAuthentication method " + user.getUserName());
    	String encodedPwd = new BCryptPasswordEncoder().encode(user.getPassword());
        return new org.springframework.security.core.userdetails.User(user.getUserName(), encodedPwd,
                user.isEnabled(), true, true, true, authorities);
    }
    
    
}