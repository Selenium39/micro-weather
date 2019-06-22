package com.selenium.microweathercollectionclient.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class WeatherResponse implements Serializable {
    private Weather data;
    private Integer status;
    private String desc;
}
