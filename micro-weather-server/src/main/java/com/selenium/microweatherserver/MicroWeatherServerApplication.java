package com.selenium.microweatherserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroWeatherServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroWeatherServerApplication.class, args);
    }

}
