package com.selenium.singleweather.serviceImpl;

import com.selenium.singleweather.service.WeatherDataService;
import com.selenium.singleweather.service.WeatherReportService;
import com.selenium.singleweather.vo.Weather;
import com.selenium.singleweather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WeatherReportServiceImpl implements WeatherReportService {
    @Autowired
	private WeatherDataService weatherDataService;
	
	@Override
	public Weather getWeatherByCityName(String cityName) {
		WeatherResponse response=weatherDataService.getDataByCityName(cityName);
		return response.getData();
	}

}
