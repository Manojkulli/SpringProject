package com.spring_project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_project.dao.UserDao;
import com.spring_project.dto.Application;
import com.spring_project.dto.User;

@Service
public class UserService {

	@Autowired
	UserDao dao;

	public User saveUser(User user) {
		return dao.saveUser(user);
	}

	public List<Application> getApplication(Application application) {

		List<Application> list = new ArrayList<Application>();
		list.add(application);
		return list;
	}
	
	public User getByEmail(User user){

		User user1=dao.findByEmail(user.getEmail());
		if(user1.getPassword().equals(user.getPassword())){
			return user1;
		}else{
			return null;
		}
	}
	
	public User saveApplication(User user){
		
		User user1= dao.findById(user.getId());
		dao.updateUser(user1);
		
		return user1;
	}
	
	public List<Application> getAllApplication(User user){
		User user1=dao.getAllApplication(user);
		return user1.getApplication();
	}
	
	public Application getById(int id){
		return dao.findApplicationById(id);
	}
}
