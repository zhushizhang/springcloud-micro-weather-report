package com.supcon.cloud.service;

import com.supcon.cloud.vo.WeatherRespose;

/**
 * 天气数据接口
 * @author Administrator
 *
 */
public interface WeatherDataService {

	/**
	 * 
	* @Title: getDataByCityId 
	* @Description: 根据城市id获取天气数据
	* @param @return    
	* @return WeatherRespose 
	* @author zhushizhang   
	* @throws
	 */
	WeatherRespose getDataByCityId(String cityId);
	
	/**
	 * 
	* @Title: getDataByCityName 
	* @Description: 根据城市名称获取天气数据
	* @param @param cityName
	* @param @return    
	* @return WeatherRespose 
	* @author zhushizhang   
	* @throws
	 */
	WeatherRespose getDataByCityName(String cityName);
	/**
	 * 
	* @Title: syncDataByCityId 
	* @Description: 根据城市的id去同步数据
	* @param @param cityId    
	* @return void 
	* @author zhushizhang   
	* @throws
	 */
	void syncDataByCityId(String cityId);
}
