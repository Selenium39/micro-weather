package com.selenium.microweathercollectionclient.weatherCollectionService;

import com.selenium.microweathercollectionclient.vo.WeatherResponse;

public interface WeatherDataCollectionService {
    void synDataByCityName(String cityName);
}
