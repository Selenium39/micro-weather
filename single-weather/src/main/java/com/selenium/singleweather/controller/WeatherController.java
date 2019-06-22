package com.selenium.singleweather.controller;

import com.selenium.singleweather.service.CityDataService;
import com.selenium.singleweather.service.WeatherDataService;
import com.selenium.singleweather.service.WeatherReportService;
import com.selenium.singleweather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/weather")
public class WeatherController {
	@Autowired
	private WeatherDataService weatherDataService;

	@Autowired
	private WeatherReportService weatherReportService;

	@Autowired
	private CityDataService cityDataService;

	@GetMapping("/cityId/{cityId}")
	public WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId) {
		return weatherDataService.getDataByCityId(cityId);
	}

	@GetMapping("/cityName/{cityName}")
	public WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName) {
		return weatherDataService.getDataByCityName(cityName);
	}

	@GetMapping("/view/cityName/{cityName}")
	public ModelAndView getWeatherByCityName1(@PathVariable("cityName") String cityName, Model model) {
		model.addAttribute("title", "天气预报");
		model.addAttribute("citys", cityDataService.getAllCity());
		model.addAttribute("selected",cityName);	
		model.addAttribute("report", weatherReportService.getWeatherByCityName(cityName));
		return new ModelAndView("weather/report", "reportModel", model);
	}
}
