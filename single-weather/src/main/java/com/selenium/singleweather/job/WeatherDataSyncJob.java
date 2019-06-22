package com.selenium.singleweather.job;

import java.util.List;

import com.selenium.singleweather.service.CityDataService;
import com.selenium.singleweather.service.WeatherDataService;
import com.selenium.singleweather.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.QuartzJobBean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class WeatherDataSyncJob extends QuartzJobBean {
    @Autowired
    private CityDataService cityDataService;
    @Autowired
    private WeatherDataService weatherDataService;
    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini";

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        //获取城市列表
        List<City> cityCities = cityDataService.getAllCity();
        //遍历城市获取城市Name
        for (City city : cityCities) {
            String cityName = city.getCityName();
            weatherDataService.synDataByCityName(cityName);
        }

    }

}
