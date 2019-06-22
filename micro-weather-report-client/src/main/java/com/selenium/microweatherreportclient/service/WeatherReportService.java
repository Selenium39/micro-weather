package com.selenium.microweatherreportclient.service;


import com.selenium.microweatherreportclient.vo.Weather;

public interface WeatherReportService {
    Weather getWeatherByCityName(String cityName);

}
