package com.selenium.microweatherclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroWeatherClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroWeatherClientApplication.class, args);
    }

}
