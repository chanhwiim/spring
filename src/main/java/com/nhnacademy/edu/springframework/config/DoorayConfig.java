package com.nhnacademy.edu.springframework.config;

import com.nhn.dooray.client.DoorayHookSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class DoorayConfig {

    @Bean
    public DoorayHookSender doorayHookSender() {
        String uri = "https://hook.dooray.com/services/3204376758577275363/3727553265487230503/DIiyr9z0ROKJksd5yMFedQ";
        RestTemplate restTemplate = new RestTemplate();
        return new DoorayHookSender(restTemplate, uri);
    }
}
