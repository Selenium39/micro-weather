package com.selenium.microweatherfeignclient.controller;

import com.selenium.microweatherfeignclient.service.CityClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityClient cityClient;
    @RequestMapping("/cities")
    public String getAllList(){
        //通过Feign Client进行查找
        String body=cityClient.getAllCity();
        return body;
    }
}
