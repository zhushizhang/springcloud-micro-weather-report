package com.supcon.cloud.service;

import com.supcon.cloud.vo.Weather;

/**
 * 
 * @author Administrator
 *天气预报服务
 */
public interface WeatherReportService {

	/**
	 * 
	* @Title: getDataByCityId 
	* @Description: 根据城市id来查询
	* @param @param cityId
	* @param @return    
	* @return Weather 
	* @author zhushizhang   
	* @throws
	 */
	Weather getDataByCityId(String cityId);
}
