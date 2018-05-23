package com.supcon.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supcon.cloud.service.WeatherDataService;
import com.supcon.cloud.vo.WeatherRespose;

@RestController
public class WeatherController {

	@Autowired
	private WeatherDataService weatherDataService;
	
	@RequestMapping("cityId/{cityId}")
	public WeatherRespose getWeatherByCityId(@PathVariable("cityId") String cityId){
		WeatherRespose weatherRespose = weatherDataService.getDataByCityId(cityId);
		return weatherRespose;
	}
	
	@RequestMapping("cityName/{cityName}")
	public WeatherRespose getWeatherByCityName(@PathVariable("cityName") String cityName){
		WeatherRespose weatherRespose = weatherDataService.getDataByCityName(cityName);
		return weatherRespose;
	}
}
