package com.supcon.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.supcon.cloud.service.CityDataService;
import com.supcon.cloud.service.WeatherDataService;
import com.supcon.cloud.service.WeatherReportService;
import com.supcon.cloud.vo.Weather;
import com.supcon.cloud.vo.WeatherRespose;

/**
 * WeatherReport的控制层
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {

	@Autowired
	private CityDataService cityDataService;
	@Autowired
	private WeatherReportService weatherReportService;
	@RequestMapping("cityId/{cityId}")
	public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId , Model model) throws Exception{
		model.addAttribute("title", "朱诗璋的天气预报");
		model.addAttribute("cityId", cityId);
		model.addAttribute("cityList", cityDataService.listCity());
		model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
		return new ModelAndView("weather/report","reportModel",model);
	}
}
