package com.selenium.singleweather.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Weather implements Serializable {
	private Yesterday yesterday;
	private String city;
	private List<Forecast> forecast;
	private String ganmao;
	private String wendu;

}
