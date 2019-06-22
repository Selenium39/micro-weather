package com.selenium.microweatherfeignclient.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("micro-weather-city-client")
public interface CityClient {
    @RequestMapping("/city/cities")
    String getAllCity();
}
