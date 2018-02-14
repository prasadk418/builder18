package com.builder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.builder.service.LoginServiceImpl;

public class LoginController {

	
	@Autowired
	private LoginServiceImpl loginService;
	
	
	public  ModelAndView loginCheck()
	{
		
		return null;
	}
}
