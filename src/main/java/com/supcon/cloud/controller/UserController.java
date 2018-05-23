package com.supcon.cloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@RequestMapping("/helloworld")
	public String helloworld(){
		return "helloWorld";
	}
}
