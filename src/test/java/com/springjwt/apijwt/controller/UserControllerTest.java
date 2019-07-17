package com.springjwt.apijwt.controller;

import com.springjwt.apijwt.pojo.AuthRequest;
import com.springjwt.apijwt.pojo.UserInfo;
import com.springjwt.apijwt.rdsentities.User;
import com.springjwt.apijwt.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.Mockito.when;

public class UserControllerTest {
    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Before
    public void init_mocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateUser() throws Exception {

        UserInfo userInfo = new UserInfo("TESTMAGEID");

        when(userService.retrieveAuthUserDetails("CODE")).thenReturn(userInfo);
        when(userService.retrieveOrCreateUser(anyObject())).thenReturn(new User());

        AuthRequest authRequest = new AuthRequest();
        authRequest.setCode("CODE");

        ResponseEntity<String> mageId =  userController.create(authRequest, anyObject());

        assertEquals("", "TESTMAGEID", mageId.getBody());
    }



}
