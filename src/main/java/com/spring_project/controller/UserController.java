package com.spring_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring_project.dto.User;

@Controller
public class UserController {
	
	@RequestMapping("login")
	public ModelAndView login(){
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("login.jsp");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}
	
	@RequestMapping("signup")
	public ModelAndView signup(){
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("signup.jsp");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}

}
