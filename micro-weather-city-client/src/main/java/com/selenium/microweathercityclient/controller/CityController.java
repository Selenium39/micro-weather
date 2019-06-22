package com.selenium.microweathercityclient.controller;

import com.selenium.microweathercityclient.cityDataService.CityDataService;
import com.selenium.microweathercityclient.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityDataService cityDataService;

    @RequestMapping("/cities")
    public List<City> getAllCity() {
        return cityDataService.getAllCity();
    }
}
