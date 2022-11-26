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
		service.saveUser(user);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("index.jsp");
		return modelAndView;	
	}
	
	@RequestMapping("userlogin")
	public ModelAndView verifyUser(@ModelAttribute User user) {
		ModelAndView modelAndView=new ModelAndView();
		User user2=service.getByEmail(user);
		if(user2!=null)
		{
			modelAndView.addObject("user", user2.getName());
			modelAndView.addObject("ulist", service.getAllUser());
			modelAndView.setViewName("viewuser.jsp");
		}
		else
		{
			modelAndView.setViewName("login.jsp");
		}
		return modelAndView;
	}
	
	@RequestMapping("saveapplication")
	public ModelAndView saveApplication(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("signup.jsp");
		return modelAndView;
	}

}
