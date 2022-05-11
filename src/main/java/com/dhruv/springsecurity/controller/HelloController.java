package com.dhruv.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String getHelloMessage(){
        return "Hello";
    }

    @GetMapping("/admin")
    public String getHelloMessageAdmin(){
        return "Hello admin";
    }

    @GetMapping("/user")
    public String getUserMessage(){
        return "Hello user";
    }

}
