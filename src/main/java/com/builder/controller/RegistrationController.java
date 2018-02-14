package com.builder.controller;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.builder.domain.User;
import com.builder.service.RegisterServiceImpl;
import com.builder.util.BuilderUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class RegistrationController {

	@Autowired
	private RegisterServiceImpl registerService;
	
	
	@RequestMapping("/")
	public ModelAndView indexPage()
	{
		System.out.println("index got...1");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	@RequestMapping("/register")
	public  ModelAndView register1() throws JsonParseException, JsonMappingException, IOException
	{
		System.out.println("register");
		return new ModelAndView("register");
	}
	@RequestMapping(path="/doregister" , method=RequestMethod.POST)
	public  ModelAndView register(@RequestBody String jsonString) throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper mapper=new ObjectMapper();
		User u=mapper.readValue(BuilderUtil.paramJson(jsonString), User.class);
		boolean b=registerService.registerUser(u);
		String msg="Not Registerd";
		if(b==true)
			msg="Registered successfully";
		return new ModelAndView("register", "msg", msg);
	}
	
	@RequestMapping("/login")
	public String login()
	{
		System.out.println("login");
		///registerService.registerUser();
		return "register";
	}
	
	
	
}
