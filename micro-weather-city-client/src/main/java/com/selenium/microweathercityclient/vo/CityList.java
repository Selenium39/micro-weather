package com.selenium.microweathercityclient.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement(name="citys")
@XmlAccessorType(XmlAccessType.FIELD)
public class CityList {
	@XmlElement(name="city")
	private List<City> cityList;

}
