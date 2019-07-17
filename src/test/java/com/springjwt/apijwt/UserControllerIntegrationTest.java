package com.springjwt.apijwt;

import com.springjwt.apijwt.pojo.AuthRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class UserControllerIntegrationTest {
    @LocalServerPort
    private int port;
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    @Test
    public void testCreateUser() throws Exception {
        //setting up the request headers
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);

        //setting up the request body
        AuthRequest authRequest = new AuthRequest();
        authRequest.setCode("SOME_CODE");

        //request entity is created with request body and headers
        HttpEntity<AuthRequest> requestEntity = new HttpEntity<>(authRequest, requestHeaders);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/user"), HttpMethod.POST, requestEntity, String.class);
        String actual = response.getBody().toString();
        log.debug("Returned response string is"+actual);
        assertTrue(actual.contains("MAGE"));
    }
//    @Test
////    public void testRetrieveStudent() throws Exception {
////        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
////        ResponseEntity<String> response = restTemplate.exchange(
////                createURLWithPort("/students/1"), HttpMethod.GET, entity, String.class);
////        String expected = "{\"id\":1,\"name\":\"Rajesh Bhojwani\",\"description\":\"Class 10\"}";
////        JSONAssert.assertEquals(expected, response.getBody(), false);
////    }


    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
