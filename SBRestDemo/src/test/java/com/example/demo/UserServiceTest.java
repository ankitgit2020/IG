package com.example.demo;
import com.demo.dao.RoleDao;
import com.demo.dao.UserDao;
import com.demo.model.UserModel;
import com.demo.service.UserService;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.MockitoAnnotations.initMocks;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

    @Mock
    private UserDao mockUserRepository;
    @Mock
    private RoleDao mockRoleRepository;
    @Mock
    private BCryptPasswordEncoder mockBCryptPasswordEncoder;

    private UserService userServiceUnderTest;
    private UserModel user;

  
    public void setUp() {
        initMocks(this);
        userServiceUnderTest = new UserService(mockUserRepository,
                                               mockRoleRepository,
                                               mockBCryptPasswordEncoder);
        /** user = UserModel.builder()
                .id(1)
                .name("Gustavo")
                .lastName("Ponce")
                .email("test@test.com")
                .build(); **/

        Mockito.when(mockUserRepository.save(any()))
                .thenReturn(user);
       // Mockito.when(mockUserRepository.findByEmail(anyString()))
                //.thenReturn(user);
    }

    @Test
    public void testFindUserByEmail() {
        // Setup
        final String email = "test@test.com";

        // Run the test
        //final UserModel result = userServiceUnderTest.findUserByEmail(email);

        // Verify the results
       // assertEquals(email, result.getEmail());
    }

    @Test
    public void testSaveUser() {
        // Setup
        final String email = "test@test.com";

        // Run the test
        UserModel result =  user;//userServiceUnderTest.saveUser(UserModel.builder().build());

        // Verify the results
        //assertEquals(email, result.getEmail());
        
    }
}