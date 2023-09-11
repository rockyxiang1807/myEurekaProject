package com.rocky1807.admin.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * wenhui.xiang
 * 2023/09/11 6:00 下午
 */

@RestController
public class HystrixTestController {

    @GetMapping("/hystrix")
    @HystrixCommand(
            // 标识线程池 保持唯一
            threadPoolKey = "threadPoolKeyByFeign",
            // 线程池细节属性配置
            threadPoolProperties = {
                    // 线程数
                    @HystrixProperty(name="coreSize",value = "10"),
                    //最大线程数量
                    @HystrixProperty(name="maximumSize",value = "10"),
                    // 等待队列长度
                    @HystrixProperty(name="maxQueueSize",value="-1"),
                    //如果需要动态修改队列长度的话可以设置此值，即使队列未满，队列内作业达到此值时同样会拒绝请求。此值默认是 5
                    @HystrixProperty(name="queueSizeRejectionThreshold",value="5"),
                    //空闲时间1min
                    @HystrixProperty(name="keepAliveTimeMinutes",value="1")
            },
            // 熔断的一些细节属性配置
            commandProperties = {
                    // 调用服务超时时间
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000"),
                    // 统计时间窗口定义
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds",value = "10000"),
                    //桶数量 保证与统计时间窗口整除
                    @HystrixProperty(name = "metrics.rollingPercentile.numBuckets",value = "10"),
                    // 统计时间窗口内的最小请求数
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "20"),
                    // 统计时间窗口内的错误数量百分比阈值
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50"),
                    // 自我修复时的活动窗口长度
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "5000")
            },
            // 降级方法
            fallbackMethod = "myFallBack"
    )
    public String hystrixTest(String str){
        if(str.contains("s")){
            throw new RuntimeException();
        }
        return str+"ssss";
    }

    private String myFallBack(String str){
        return ">>>>>服务端服务降级>>>>>";
    }
}
