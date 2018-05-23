package com.supcon.cloud.job;

import java.util.ArrayList;
import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.supcon.cloud.service.CityDataService;
import com.supcon.cloud.service.WeatherDataService;
import com.supcon.cloud.vo.City;

public class WeatherDataSyncJob extends QuartzJobBean {

	private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);
	
	@Autowired
	private CityDataService cityDataService;
	@Autowired
	private WeatherDataService weatherDataService;
	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		// TODO Auto-generated method stub
		logger.info("Weather Data Sync Job start ");
		//获取城市id列表
		List<City> cityList = null;
		try {
			cityList = cityDataService.listCity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("exception !",e);
		}
		//遍历城市id获取天气情况
		for(City city : cityList){
			String cityId = city.getCityId();
			weatherDataService.syncDataByCityId(cityId);
			logger.info("Weather Data Sync Job ,cityId:"+cityId);
		}
		logger.info("Weather Data Sync Job end ");
	}

}
