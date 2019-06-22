package com.selenium.singleweather.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class Yesterday implements Serializable {
         private String date;
         private String high;
         private String fx;
         private String low;
         private String fl;
         private String type;
}
