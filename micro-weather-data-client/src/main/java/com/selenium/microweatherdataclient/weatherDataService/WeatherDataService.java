package com.selenium.microweatherdataclient.weatherDataService;

import com.selenium.microweatherdataclient.vo.WeatherResponse;

public interface WeatherDataService {
    WeatherResponse getDataByCityId(String cityId);

    WeatherResponse getDataByCityName(String cityName);
}
