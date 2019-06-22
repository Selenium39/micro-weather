package com.selenium.microweatherhystrixclient.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.selenium.microweatherhystrixclient.feignService.CityClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityClient cityClient;

    @HystrixCommand(fallbackMethod = "errorHandler")
    @RequestMapping("/cities")
    public String getAllCity(){
       return cityClient.getAllCity().toString();
    }
    public String errorHandler(){
        return "City Service was down";
    }
}
