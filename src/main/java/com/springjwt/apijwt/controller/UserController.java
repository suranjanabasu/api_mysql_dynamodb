package com.springjwt.apijwt.controller;


import com.springjwt.apijwt.rds_entities.User;
import com.springjwt.apijwt.pojo.AuthRequest;
import com.springjwt.apijwt.pojo.UserInfo;
import com.springjwt.apijwt.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("authenticate")
    public ResponseEntity<String> authenticate(@RequestBody AuthRequest authRequest, final HttpServletRequest request) {
        log.debug("Entering authenticate with code: "+authRequest.getCode());

        UserInfo userInfo = userService.retrieveAuthUserDetails(authRequest.getCode());

        userService.retrieveOrCreateUser(userInfo);

        return ResponseEntity.status(HttpStatus.OK).body(
                "MageId is " + userInfo.getMageId());
    }

}
