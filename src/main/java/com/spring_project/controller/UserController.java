package com.spring_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring_project.dto.Application;
import com.spring_project.dto.User;
import com.spring_project.service.UserService;

@Controller
public class UserController {
	
	@RequestMapping("login")
	public ModelAndView login(){
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("login.jsp");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}
	
	@RequestMapping("signin")
	public ModelAndView signup(){
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("signup.jsp");
		modelAndView.addObject("user", new User());
		return modelAndView;
		
	}
	
	@Autowired
	UserService service;
	
	@RequestMapping("usersignup")
	public ModelAndView saveUser(@ModelAttribute User user){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("application.jsp");
		return modelAndView;	
	}
	
	@RequestMapping("saveapplication")
	public ModelAndView saveApplication(@ModelAttribute Application application){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("application", new Application());
		modelAndView.setViewName("application.jsp");
		return modelAndView;
	}

}
