package com.selenium.microweatherreportclient.controller;

import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.selenium.microweatherreportclient.feignService.CityClient;
import com.selenium.microweatherreportclient.feignService.ZuulClient;
import com.selenium.microweatherreportclient.service.WeatherReportService;
import com.selenium.microweatherreportclient.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {
	@Autowired
	private WeatherReportService weatherReportService;
	@Autowired
	private CityClient cityClient;
	@Autowired
	private ZuulClient zuulClient;

	@GetMapping("/view/cityName/{cityName}")
	@HystrixCommand(fallbackMethod = "errorHandler")
	public ModelAndView getWeatherByCityName1(@PathVariable("cityName") String cityName, Model model) {
		model.addAttribute("title", "天气预报");
		//通过feign直接调用具体API
		//model.addAttribute("citys", cityClient.getAllCity());
		//通过feign调用API网关(Zuul)
		model.addAttribute("citys", zuulClient.getAllCity());
		model.addAttribute("selected",cityName);	
		model.addAttribute("report", weatherReportService.getWeatherByCityName(cityName));
		return new ModelAndView("weather/report", "reportModel", model);
	}
	public ModelAndView errorHandler(@PathVariable("cityName") String cityName, Model model) {
		model.addAttribute("title", "天气预报");
		//通过feign直接调用具体API
		//model.addAttribute("citys", cityClient.getAllCity());
		//通过feign调用API网关(Zuul)
		List<City> cities=new ArrayList<>();
		City city1=new City();
		city1.setCityName("常德");
		City city2=new City();
		city2.setCityName("上海");
		cities.add(city1);
		cities.add(city2);
		model.addAttribute("citys", cities);
		model.addAttribute("selected",cityName);
		model.addAttribute("report", weatherReportService.getWeatherByCityName(cityName));
		return new ModelAndView("weather/report", "reportModel", model);
	}
}
