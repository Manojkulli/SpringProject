package com.spring_project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring_project.dto.Application;
import com.spring_project.dto.User;

@Repository
public class UserDao {

	@Autowired
	EntityManager entityManager;

	public User saveUser(User user) {

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return user;

	}

	public User updateUser(User user) {

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();
		return user;

	}

	public User findByEmail(String email) {

		return entityManager.createQuery("select s from User s where s.email=?1", User.class).setParameter(1, email)
				.getSingleResult();
	}

	public User findById(int id) {
		return entityManager.find(User.class, id);
	}
	
	public User  getAllApplication(User user){
		
		return entityManager.createQuery("select s from User s where s.id=?1",User.class).setParameter(1, user.getId()).getSingleResult();
		
	}
	public Application findApplicationById(int id) {
		return entityManager.find(Application.class, id);
	}
	
	public Application updateApplication(Application application){
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Application application1=entityManager.find(Application.class, application.getId());
		entityTransaction.begin();
		entityManager.merge(application1);
		entityTransaction.commit();
		return application1;
	}
}
