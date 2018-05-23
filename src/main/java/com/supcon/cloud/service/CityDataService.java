package com.supcon.cloud.service;

import java.util.List;

import com.supcon.cloud.vo.City;

public interface CityDataService {

	/**
	 * 
	* @Title: listCity 
	* @Description: 获取城市列表
	* @param @return
	* @param @throws Exception    
	* @return List<City> 
	* @author zhushizhang   
	* @throws
	 */
	List<City> listCity() throws Exception;
	
	
}
