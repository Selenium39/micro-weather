package com.selenium.microweatherhystrixclient.feignService;

import com.selenium.microweatherhystrixclient.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@FeignClient("micro-weather-city-client")
public interface CityClient {
    @RequestMapping("/city/cities")
    List<City> getAllCity();
}
