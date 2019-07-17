package com.springjwt.apijwt.controller;

import com.springjwt.apijwt.pojo.UserInfo;
import com.springjwt.apijwt.service.KeysService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertTrue;


import java.util.Optional;


public class KeysControllerTest {

    @Mock
    private KeysService keyService;

    @InjectMocks
    private KeysController keysController;

    @Before
    public void init_mocks() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testCreateKeys() throws Exception {

        UserInfo userInfo = new UserInfo("TESTMAGEID");

        when(keyService.createApiKeys(userInfo)).thenReturn("TESTAPIKEY");
        ResponseEntity<String> apiKey =  keysController.createKey(userInfo);

        assertEquals("", "TESTAPIKEY", apiKey.getBody());
    }

    @Test
    public void testCreateKeysWithoutMageId() throws Exception {

       ResponseEntity<String> response =  keysController.createKey(new UserInfo());

       assertEquals("", "MageId needs to be present", response.getBody());
    }

    @Test
    public void testGetKeys() {
        when(keyService.getKey(anyString())).thenReturn("TESTAPIKEY");
        ResponseEntity<String> apiKey =  keysController.getKeys("TESTUID");

        assertEquals("", "TESTAPIKEY", apiKey.getBody());
    }

    @Test
    public void testGetKeysWithoutMageId() throws Exception {

        ResponseEntity<String> response =  keysController.getKeys("");

        assertEquals("", "MageId needs to be present", response.getBody());
    }
}