package com.supcon.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supcon.cloud.vo.Weather;
import com.supcon.cloud.vo.WeatherRespose;

@Service
public class WeatherReportServiceImpl implements WeatherReportService{

	@Autowired
	private WeatherDataService weatherDataService; 
	@Override
	public Weather getDataByCityId(String cityId) {
		// TODO Auto-generated method stub
		WeatherRespose  weatherRespose = weatherDataService.getDataByCityId(cityId);
		return weatherRespose.getData();
	}

}
