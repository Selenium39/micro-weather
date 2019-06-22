package com.selenium.microweatherreportclient.serviceImpl;

import com.selenium.microweatherreportclient.feignService.WeatherClient;
import com.selenium.microweatherreportclient.feignService.ZuulClient;
import com.selenium.microweatherreportclient.service.WeatherReportService;
import com.selenium.microweatherreportclient.vo.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WeatherReportServiceImpl implements WeatherReportService {
    //1.通过Feign调用具体API直接注入
   /* @Autowired
    private WeatherClient weatherClient;


    @Override
    public Weather getWeatherByCityName(String cityName) {
        return weatherClient.getWeatherByCityName(cityName).getData();
    }*/


    //2.通过Feign调用API(Zuul)网关注入
    @Autowired
    private ZuulClient zuulClient;
    @Override
    public Weather getWeatherByCityName(String cityName) {
        return zuulClient.getWeatherByCityName(cityName).getData();
    }
}
