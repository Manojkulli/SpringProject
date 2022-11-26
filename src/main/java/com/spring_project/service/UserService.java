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
}
