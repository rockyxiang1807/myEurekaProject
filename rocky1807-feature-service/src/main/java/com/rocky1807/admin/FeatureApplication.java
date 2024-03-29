package com.rocky1807.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FeatureApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeatureApplication.class, args);
    }

}
