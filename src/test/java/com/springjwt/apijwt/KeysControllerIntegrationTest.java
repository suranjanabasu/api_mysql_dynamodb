package com.springjwt.apijwt;

import com.springjwt.apijwt.pojo.AuthRequest;
import com.springjwt.apijwt.pojo.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class KeysControllerIntegrationTest {
    @LocalServerPort
    private int port;
    TestRestTemplate restTemplate = new TestRestTemplate();


    @Test
    public void testGetKey() throws Exception {

        //Create the user in MYSQl by calling the /authenticate endpoint
        String mageId = createUser();
        //String mageId = "RANDOM";

        //Create the Key
        String apiKey = createKey(mageId);

        //setting up the request headers
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);


        //request entity is created with request body and headers
        HttpEntity<String> requestEntity = new HttpEntity<String>(mageId, requestHeaders);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/keys/"+ mageId), HttpMethod.GET, requestEntity, String.class);
        String actual = response.getBody().toString();
        log.debug("Returned apiKey is"+actual);
        assertEquals("Api Key returned should match the one created in dynamodb in createKeys operation", apiKey, actual );
    }

    private String createKey(String mageId) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);

        //setting up the request body
        UserInfo userInfo = new UserInfo();
        userInfo.setMageId(mageId);

        //request entity is created with request body and headers
        HttpEntity<UserInfo> requestEntity = new HttpEntity<>(userInfo, requestHeaders);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/keys/"), HttpMethod.POST, requestEntity, String.class);
        return response.getBody().toString();
    }

    private String createUser() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);

        //setting up the request body
        AuthRequest authRequest = new AuthRequest();
        authRequest.setCode("SOME_CODE");

        //request entity is created with request body and headers
        HttpEntity<AuthRequest> requestEntity = new HttpEntity<>(authRequest, requestHeaders);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/user"), HttpMethod.POST, requestEntity, String.class);
        return response.getBody().toString();
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
