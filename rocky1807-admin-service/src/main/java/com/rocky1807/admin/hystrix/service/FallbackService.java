package com.rocky1807.admin.hystrix.service;

import org.springframework.stereotype.Service;

/**
 * wenhui.xiang
 * 2023/09/11 5:57 下午
 */


@Service
public class FallbackService implements HystrixTestService {

    @Override
    public String hystrixTest(String str) {
        return ">>>>>客户端服务降级>>>>>";
    }
}