package com.spring_project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring_project.dto.User;

@Repository
public class UserDao {
	
	@Autowired
	EntityManager entityManager;

	public User saveUser(User user ){
		
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return user;
		
	}
	public User updateUser(User user) {
		
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();
		return user;
	}
	public User deleteUser(int id) {
		
		EntityTransaction entityTransaction=entityManager.getTransaction();
		User user=entityManager.find(User.class, id);
		entityTransaction.begin();
		entityManager.remove(user);
		entityTransaction.commit();
		return user;
	}
	public List<User> getAllUser(){
		
		Query query=entityManager.createQuery("Select u from User u",User.class);
		List<User> userList=query.getResultList();
		return userList;
	}
	public User getById(int id) {
		
		User user=entityManager.find(User.class, id);
		return user;
	}
public User getByEmail(String email) {
		
	Query query=entityManager.createQuery("Select u from User u where u.email=?1",User.class);
	User user=(User)query.setParameter(1, email).getSingleResult();
	return user;
	}
	
	
}
