package com.viseo.jfrogspringboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "hello")
@RequestMapping("/api/v1")
public class HelloController {
    @GetMapping("/hello")
    @ApiOperation(value = "Hello GET", notes = "")
    public String getHello() {
        return "Hello World! From GET Method";
    }

    @PostMapping("/hello")
    public String postHello() {
        return "Hello World! From POST Method";
    }
}
