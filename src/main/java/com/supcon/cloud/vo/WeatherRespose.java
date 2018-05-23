package com.supcon.cloud.vo;

import java.io.Serializable;

public class WeatherRespose implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Weather data;
	public Weather getData() {
		return data;
	}
	public void setData(Weather data) {
		this.data = data;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	private Integer status;
	private String desc;
}
