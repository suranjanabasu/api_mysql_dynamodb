package com.springjwt.apijwt.controller;

import com.springjwt.apijwt.pojo.UserInfo;
import com.springjwt.apijwt.service.KeysService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/keys")
@Slf4j
public class KeysController {

    @Autowired
    private KeysService keysService;


    //Remember the id of the user comes from session
    //todo:  will be no mageId passed in once the session context is established. The stateless service is
    // done now just for testing
    @GetMapping("/{mageId}")
    public ResponseEntity<String> getKeys(@PathVariable("mageId") String mageId ) {
        //todo: Create a custom exception
        if (StringUtils.isEmpty(mageId) ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    "MageId needs to be present");
        }
        String apiKey = keysService.getKey(mageId);
        if (StringUtils.isEmpty(apiKey)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    "ApiKey Not Found ");
        }

        return ResponseEntity.status(HttpStatus.OK).body(
                "ApiKey is " + apiKey);
    }

    @PostMapping("/")
    public ResponseEntity<String> createKey(@RequestBody UserInfo userInfo, final HttpServletRequest request) {

        //todo: Create a custom exception
        if (StringUtils.isEmpty(userInfo.getMageId()) ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    "MageId needs to be present");
        }

        String apiKey = keysService.createApiKeys(userInfo);

        return ResponseEntity.status(HttpStatus.OK).body(
                "ApiKey is " + apiKey);
    }
}
