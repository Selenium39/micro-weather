package com.selenium.singleweather.service;


import com.selenium.singleweather.vo.WeatherResponse;

public interface WeatherDataService {

    WeatherResponse getDataByCityId(String cityId);

    WeatherResponse getDataByCityName(String cityName);

    void synDataByCityName(String cityName);
}
