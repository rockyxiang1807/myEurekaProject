package com.rocky1807.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * wenhui.xiang
 * 2023/09/11 4:48 下午
 */

@RestController
@RequestMapping("/rabbion")
public class RabbionConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/get_rabbion_message")
    public String getRabbionMessage() {
        return restTemplate.getForObject("http://feature-service//rabbion_test/message",String.class);
    }
}
