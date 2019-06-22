package com.selenium.microweatherreportclient.feignService;

import com.selenium.microweatherreportclient.vo.City;
import com.selenium.microweatherreportclient.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "micro-weather-zuul-client")
public interface ZuulClient {
    @RequestMapping("/city/city/cities")
    List<City> getAllCity();

    @RequestMapping("/data/weather/cityName/{cityName}")
    WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName);
}
