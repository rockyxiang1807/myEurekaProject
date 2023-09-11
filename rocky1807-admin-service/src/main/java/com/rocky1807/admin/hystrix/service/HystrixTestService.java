package com.rocky1807.admin.hystrix.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(value = "feature-service",fallback = FallbackService.class)
public interface HystrixTestService {

    /**
     * 测试hystrix
     */
    @GetMapping("/hystrix")
    String hystrixTest(@RequestParam String str);


}
