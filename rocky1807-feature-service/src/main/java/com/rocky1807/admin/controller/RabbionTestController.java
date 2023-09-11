package com.rocky1807.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * wenhui.xiang
 * 2023/09/11 4:44 下午
 */

@RestController
@RequestMapping("/rabbion_test")
public class RabbionTestController {

    @GetMapping("/message")
    public String getMessage() {
        return "Rabbion Message! [2]";
    }
}
