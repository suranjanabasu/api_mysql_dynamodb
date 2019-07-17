package com.springjwt.apijwt.controller;

import com.springjwt.apijwt.exceptions.ApiKeyNotFoundException;
import com.springjwt.apijwt.pojo.UserInfo;
import com.springjwt.apijwt.service.KeysService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/keys")
@Slf4j
public class KeysController {

    @Autowired
    private KeysService keysService;

    @GetMapping("/{mageId}")
    public ResponseEntity<String> getKeys(@PathVariable("mageId") String mageId ) {
        if (StringUtils.isEmpty(mageId) ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    "MageId needs to be present");
        }
        String apiKey = keysService.getKey(mageId);
        if (StringUtils.isEmpty(apiKey)) {
            throw new ApiKeyNotFoundException();
        }

        return ResponseEntity.status(HttpStatus.OK).body(
                 apiKey);
    }

    @PostMapping("/")
    public ResponseEntity<String> createKey( @Valid @RequestBody UserInfo userInfo) {
        if (StringUtils.isEmpty(userInfo.getMageId()) ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    "MageId needs to be present");
        }

        String apiKey = keysService.createApiKeys(userInfo);
        if (StringUtils.isEmpty(apiKey)) {
            throw new ApiKeyNotFoundException();
        }

        return ResponseEntity.status(HttpStatus.OK).body(
                apiKey);
    }
}
