package com.selenium.microweatherdataclient.weatherDataServiceImpl;

import java.io.IOException;

import com.selenium.microweatherdataclient.vo.WeatherResponse;
import com.selenium.microweatherdataclient.weatherDataService.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini";

    @Autowired
    private StringRedisTemplate redisTemplate;

    // 通过城市Id查找天气数据
    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        // 设置访问的uri
        String uri = WEATHER_URI + "?citykey=" + cityId;
        return doGetWeather(uri);
    }

    // 通过城市Name查找天气数据
    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "?city=" + cityName;
        return doGetWeather(uri);
    }

    // 查找天气数据
    private WeatherResponse doGetWeather(String uri) {
        // 由jackson创建的对象，用来将String转换为Json
        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse weatherResponse = null;
        String strBody = null;
        // key为uri
        String key = uri;
        if (redisTemplate.hasKey(key)) { // 先查询缓存，如果缓存中有key则取缓存中的数据
            //log.info("redis cache hit");
            strBody = redisTemplate.opsForValue().get(key);
        } else {
//            redis中没有数据则抛出异常而不是从服务接口中直接掉用
//            如果缓存中没有则通过<code> RestTemplate</code > 调用服务接口来获取并将获取的数据写入缓存
//            log.info("redis cache not hit");
//            ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
//            if (result.getStatusCodeValue() == 200) {
//                strBody = result.getBody();
//            }
//            // 将数据写入缓存
//            redisTemplate.opsForValue().set(key, strBody, TIME_OUT, TimeUnit.SECONDS);

            throw new RuntimeException("Data dont't have");
        }
        try {
            weatherResponse = mapper.readValue(strBody, WeatherResponse.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weatherResponse;
    }
}
