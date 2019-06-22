package com.selenium.microweatherreportclient.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class WeatherResponse implements Serializable {
    private Weather data;
    private Integer status;
    private String desc;
}
