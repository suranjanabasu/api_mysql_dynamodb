package com.springjwt.apijwt.service;

import com.springjwt.apijwt.dynamodbrepositories.ApiKeysRepository;
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

public class KeysServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private ApiKeysRepository apiKeysRepository;

    @InjectMocks
    KeyServiceImpl keysService;

    @Before
    public void init_mocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateApiKey() {
        UserInfo userInfo = new UserInfo();
        userInfo.setMageId("MageID");
        User user = new User();
        user.setFirstname("fname");
        user.setUid("MageID");
        when (userRepository.findByUid("MageID")).thenReturn(user);
        when (apiKeysRepository.createApiKey(user)).thenReturn("APIKEY");
        String apiKey = keysService.createApiKeys(userInfo);
        assertEquals("ApiKey created is not returned",apiKey , "APIKEY" );
    }

    @Test
    public void testGetApiKey() {

        User user = new User();
        user.setFirstname("fname");
        user.setUid("MageID");
        user.setApiKey("ApiKey");
        when (userRepository.findByUid("MageID")).thenReturn(user);

        String apiKey = keysService.getKey("MageID");
        assertEquals("ApiKey created is not returned",apiKey , "ApiKey" );
    }




}
