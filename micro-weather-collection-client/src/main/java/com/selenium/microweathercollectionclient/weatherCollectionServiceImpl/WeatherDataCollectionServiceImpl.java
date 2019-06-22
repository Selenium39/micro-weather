package com.selenium.microweathercollectionclient.weatherCollectionServiceImpl;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.selenium.microweathercollectionclient.vo.WeatherResponse;
import com.selenium.microweathercollectionclient.weatherCollectionService.WeatherDataCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {
    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini";
    private static final Long TIME_OUT = 1800L;// 30minutes
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StringRedisTemplate redisTemplate;
    //同步数据
    @Override
    public void synDataByCityName(String cityName) {
        String uri = WEATHER_URI + "?city=" + cityName;
        saveData(uri);
    }

    //将数据保存到redis
    private void saveData(String uri) {
        // 由jackson创建的对象，用来将String转换为Json
        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse weatherResponse = null;
        String strBody = null;
        // key为uri
        String key = uri;
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        if (result.getStatusCodeValue() == 200) {
            strBody = result.getBody();
        }
        // 将数据写入缓存
        redisTemplate.opsForValue().set(key, strBody, TIME_OUT, TimeUnit.SECONDS);
        try {
            weatherResponse = mapper.readValue(strBody, WeatherResponse.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
