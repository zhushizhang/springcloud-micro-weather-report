package com.supcon.cloud.service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.supcon.cloud.vo.WeatherRespose;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {
	private static final String WEATHER_URI="http://wthrcdn.etouch.cn/weather_mini?"; 
	private final static Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);
	private static final long TIME_OUT = 1000L;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Override
	public WeatherRespose getDataByCityId(String cityId) {
		// TODO Auto-generated method stub
		String uri=WEATHER_URI+"citykey="+cityId;
		return doGetWeather(uri);
	}

	@Override
	public WeatherRespose getDataByCityName(String cityName) {
		// TODO Auto-generated method stub
		String uri=WEATHER_URI+"city="+cityName;
		return doGetWeather(uri);
	}
	
	private WeatherRespose doGetWeather(String uri){
		ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
		WeatherRespose resp = null;
		ObjectMapper mapper = new ObjectMapper();
		//在这里先查缓存，如果缓存没有再查接口
		String key = uri;
		String strBody = null;
		ValueOperations<String, String>  ops = stringRedisTemplate.opsForValue();
		if(stringRedisTemplate.hasKey(key)){
			logger.info("hasRedis,get it ");
			//这里获取到redis里面取到的值
			strBody = ops.get(key);
		}else{
			if(respString.getStatusCodeValue()==200){
				strBody = respString.getBody();
				//把值写入缓存
				ops.set(key, strBody, TIME_OUT, TimeUnit.SECONDS);
				logger.info("noRedis,get it ");
			}
		}
		try {
			resp = mapper.readValue(strBody, WeatherRespose.class);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("Error",e);
		}
		return resp;
	}

	@Override
	public void syncDataByCityId(String cityId) {
		// TODO Auto-generated method stub
		String uri=WEATHER_URI+"citykey="+cityId;
		logger.info(uri);
		this.saveWeatherData(uri);
	}
	/**
	 * 
	* @Title: saveWeatherData 
	* @Description: 把天气数据放在缓存中
	* @param @param uri    
	* @return void 
	* @author zhushizhang   
	* @throws
	 */
	private void saveWeatherData(String uri){
		ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
		//在这里先查缓存，如果缓存没有再查接口
		String key = uri;
		String strBody = null;
		ValueOperations<String, String>  ops = stringRedisTemplate.opsForValue();
		if(respString.getStatusCodeValue()==200){
			strBody = respString.getBody();
			//把值写入缓存
			ops.set(key, strBody, TIME_OUT, TimeUnit.SECONDS);
			logger.info("noRedis,get it ");
		}
	}
}
