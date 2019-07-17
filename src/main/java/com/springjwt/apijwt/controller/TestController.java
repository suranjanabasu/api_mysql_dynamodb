package com.springjwt.apijwt.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @GetMapping("/a")
    public String authenticate() {

        return "ok from a";
    }
}
