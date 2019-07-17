package com.springjwt.apijwt.service;

import com.springjwt.apijwt.rdsrepositories.UserRepository;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UserServiceTest {
    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userServiceImpl;

    @Before
    public void init_mocks() {
        MockitoAnnotations.initMocks(this);
    }

    

}
