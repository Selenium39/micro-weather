package com.selenium.singleweather.service;


import com.selenium.singleweather.vo.Weather;

public interface WeatherReportService {
    Weather getWeatherByCityName(String cityName);

}
