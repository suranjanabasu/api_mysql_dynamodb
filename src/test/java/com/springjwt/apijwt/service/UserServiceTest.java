package com.springjwt.apijwt.service;

import com.springjwt.apijwt.pojo.UserInfo;
import com.springjwt.apijwt.rdsentities.User;
import com.springjwt.apijwt.rdsrepositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userServiceImpl;

    @Before
    public void init_mocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveOrCreateUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setMageId("MageID");
        User user = new User();
        user.setFirstname("fname");
        user.setUid("MageID");
        when (userRepository.findByUid("MageID")).thenReturn(user);
        User returnedUser = userServiceImpl.retrieveOrCreateUser(userInfo);
        assertEquals("MageId must match the UUid of the database User",returnedUser.getUid() , "MageID" );
    }



}
