package com.rone.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rone
 */
@RestController
@RequestMapping
public class HelloWorldController {
    @RequestMapping("/hello")
    public String index() {
        return "Hello Service";
    }
}
