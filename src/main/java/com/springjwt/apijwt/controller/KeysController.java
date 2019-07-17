package com.springjwt.apijwt.controller;

import com.springjwt.apijwt.pojo.UserInfo;
import com.springjwt.apijwt.service.KeyServiceImpl;
import com.springjwt.apijwt.service.KeysService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    @GetMapping("/")
    public String getKeys(@PathVariable String mageId ) {

        //Hardcoding the mageId or now - This will come from the authenticated user
        //Get Keys will retrieve the user from mysql table



        return "ok from a";
    }

    @PostMapping("/")
    public String createKey(@RequestBody UserInfo userInfo, final HttpServletRequest request) {

        //Hardcoding the mageId or now - This will come from the authenticated user
        String mageId = userInfo.getMageId();

        keysService.createApiKeys("");

        //Retrieve the User details from mysql table



        //todo: Create keys in dynamodb and mysql linking is done


        return "ok from a";
    }
}
