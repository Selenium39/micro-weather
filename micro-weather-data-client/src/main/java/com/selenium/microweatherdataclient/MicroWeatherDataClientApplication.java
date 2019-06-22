package com.selenium.microweatherdataclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroWeatherDataClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroWeatherDataClientApplication.class, args);
    }

}
