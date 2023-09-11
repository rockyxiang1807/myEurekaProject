package com.rocky1807.admin.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * wenhui.xiang
 * 2023/09/11 4:47 下午
 */

@Configuration
public class RabbionConfig {
    @Bean
    @LoadBalanced
    public RestTemplate createRT() {
        return new RestTemplate();
    }

    @Bean
    public IRule createRule() {
//        //随机
//        new RandomRule();
//        //轮询
//        new RoundRobinRule();
//        //权重
//        new WeightedResponseTimeRule();
//        //最小并发
//        new BestAvailableRule();
//        //区域感知——就近原则
//        new ZoneAvoidanceRule();

        return new RoundRobinRule();
    }
}

