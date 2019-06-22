package com.selenium.singleweather.serviceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.xml.bind.JAXBException;

import com.selenium.singleweather.service.CityDataService;
import com.selenium.singleweather.util.XmlBuilder;
import com.selenium.singleweather.vo.City;
import com.selenium.singleweather.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class CityDataServiceImpl implements CityDataService {

	@Override
	public List<City> getAllCity() {
		StringBuffer buffer=null;
		//读取XML文件
		Resource resource= new ClassPathResource("citys.xml");
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(resource.getInputStream()));
		    buffer=new StringBuffer();
		    String line="";
		    while((line=reader.readLine())!=null) {
		    	buffer.append(line);
		    }
		    reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//XML转为Java对象
		CityList cityList=null;
		try {
			cityList=(CityList) XmlBuilder.xmlParseToObject(buffer.toString(),CityList.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cityList.getCityList();
	}

}
