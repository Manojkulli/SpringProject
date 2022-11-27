package com.spring_project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	User user1;
	
	
	@RequestMapping("usersignup")
	public ModelAndView saveUser(@ModelAttribute User user){
		ModelAndView modelAndView=new ModelAndView();
		service.saveUser(user);
		modelAndView.setViewName("index.jsp");
		return modelAndView;	
	}
	
	@RequestMapping("saveapplication")
	public ModelAndView saveApplication(@ModelAttribute Application application){
		ModelAndView modelAndView=new ModelAndView();
		user1.getApplication().add(application);
		modelAndView.addObject("application", new Application());
		modelAndView.setViewName("application.jsp");
		return modelAndView;
	}
	
	@RequestMapping("application")
	public ModelAndView application(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("application",new Application());
		modelAndView.setViewName("application.jsp");
		return modelAndView;
	}
		
	@RequestMapping("userlogin")
	public ModelAndView login(@ModelAttribute User user){
		ModelAndView  modelAndView=new ModelAndView();
		modelAndView.addObject("user",new User());
		user1=service.getByEmail(user);	
		if(user1!=null){
		modelAndView.setViewName("option.jsp");	
		}else{
			modelAndView.setViewName("login.jsp");	
		}
		return modelAndView;	
	}
	
	@RequestMapping("exit")
	public ModelAndView exit(Application application){
		ModelAndView modelAndView=new ModelAndView();
		service.saveApplication(user1);
		modelAndView.setViewName("option.jsp");
		modelAndView.addObject("application", new Application());
		return modelAndView;
		
	}
	
	@RequestMapping("viewapplication")
	public ModelAndView viewApplication(){
		ModelAndView modelAndView=new ModelAndView();

		modelAndView.addObject("list", service.getAllApplication(user1));
		modelAndView.setViewName("view.jsp");
		return modelAndView;
	}
	
	@RequestMapping("view")
	public ModelAndView editStudent(@RequestParam int id){
		
		ModelAndView modelAndView=new ModelAndView();
		Application application=service.getByIdd(id);
		modelAndView.addObject("application", application);
		modelAndView.setViewName("viewdetails.jsp");
		return modelAndView;
	}
	
	@RequestMapping("edit")
	public ModelAndView editApplication(@RequestParam int id){
		
		ModelAndView modelAndView=new ModelAndView();
		Application application=service.getByIdd(id);
		modelAndView.addObject("application", application);
		modelAndView.setViewName("edit.jsp");
		return modelAndView;
	}
	
	@RequestMapping("updateapplication")
	public void updateStudent(@ModelAttribute Application application,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		service.getById(application);
		request.getRequestDispatcher("view").forward(request, response);
		
	}

}
