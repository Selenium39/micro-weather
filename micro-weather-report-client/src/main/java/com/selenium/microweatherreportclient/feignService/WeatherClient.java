package com.selenium.microweatherreportclient.feignService;

import com.selenium.microweatherreportclient.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("micro-weather-data-client")
public interface WeatherClient {
    @RequestMapping("/weather/cityName/{cityName}")
    WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName);
}
