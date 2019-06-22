package com.selenium.microweathercollectionclient.job;


import com.selenium.microweathercollectionclient.feignService.CityClient;
import com.selenium.microweathercollectionclient.vo.City;
import com.selenium.microweathercollectionclient.weatherCollectionService.WeatherDataCollectionService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.QuartzJobBean;


import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Configuration
public class WeatherDataSyncJob extends QuartzJobBean {
    //注入城市服务
    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;
    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini";
    @Autowired
    private CityClient cityClient;
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        //通过feign接口来获取CityList
        List<City> cityList=cityClient.getAllCity();
        for (City city:cityList){
            log.info(city.getCityName());
            weatherDataCollectionService.synDataByCityName(city.getCityName());
        }
    }

}
