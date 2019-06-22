package com.selenium.microweatherreportclient.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Weather implements Serializable {
	private Yesterday yesterday;
	private String city;
	private List<Forecast> forecast;
	private String ganmao;
	private String wendu;

}
