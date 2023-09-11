package com.rocky1807.admin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * wenhui.xiang
 * 2023/09/11 2:49 下午
 */

@RestController
@RefreshScope
public class MyZooKeeperController {

    @Value("${myValue}")
    private String myValue;

    @GetMapping("/zooMes")
    public String basic() {
        System.out.println("==============================");
        return "ZooKeeper MyValue: " + myValue + " message!";
    }
}
