package com.supcon.cloud.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.supcon.cloud.Util.XmlBuilder;
import com.supcon.cloud.vo.City;
import com.supcon.cloud.vo.CityList;

@Service
public class CityDataServiceImpl implements CityDataService {

	@Override
	public List<City> listCity() throws Exception {
		// 读取xml文件，把数据转换为java对象
		Resource  resouce = new ClassPathResource("cityList.xml");
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(resouce.getInputStream(),"utf-8"));
		StringBuffer buffer = new StringBuffer();
		String line = "";
		while((line = bf.readLine()) != null){
			 buffer.append(line);
		}
		bf.close();
		
		CityList citylist = (CityList) XmlBuilder.xmlStrToObject(CityList.class, buffer.toString());
		
		return citylist.getCityList();
	}

}
