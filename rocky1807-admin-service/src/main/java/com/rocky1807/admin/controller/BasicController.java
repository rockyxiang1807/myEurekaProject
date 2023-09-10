package com.rocky1807.admin.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @GetMapping("/message")
    public String basic() {
        System.out.println("==============================");
        return "admin message!";
    }
}
