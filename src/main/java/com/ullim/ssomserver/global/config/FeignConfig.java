package com.ullim.ssomserver.global.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.ullim.ssomserver.global.feign")
public class FeignConfig {
}