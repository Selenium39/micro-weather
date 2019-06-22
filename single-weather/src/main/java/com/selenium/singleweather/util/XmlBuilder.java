package com.selenium.singleweather.util;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * @author wantao
 * @date 2019-06-09 5:59:27 PM
 * @description 将XML转换为vo中的对象
 */
public class XmlBuilder {
	public static Object xmlParseToObject(String xmlName, Class<?> clazz) throws JAXBException, IOException {
		Object xmlObject = null;
		Reader reader = null;
		JAXBContext context = JAXBContext.newInstance(clazz);
		// XML转为对象接口
		Unmarshaller unmarshaller = context.createUnmarshaller();
		reader = new StringReader(xmlName);
		xmlObject=unmarshaller.unmarshal(reader);
		if(reader!=null) {
			reader.close();
		}
		return xmlObject;
	}

}
