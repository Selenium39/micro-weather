package com.selenium.microweatherzuulclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class MicroWeatherZuulClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroWeatherZuulClientApplication.class, args);
    }

}
