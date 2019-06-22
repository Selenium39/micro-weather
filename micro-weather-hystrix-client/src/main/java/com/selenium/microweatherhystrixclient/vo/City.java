package com.selenium.microweatherhystrixclient.vo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name="city")
@XmlAccessorType(XmlAccessType.FIELD)
public class City {
	@XmlAttribute(name="cityName")
	private String cityName;

}
