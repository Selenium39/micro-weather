package com.selenium.singleweather.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class Forecast implements Serializable {
     private String date;
     private String high;
     private String fengli;
     private String low;
     private String fengxiang;
     private String type;
}
