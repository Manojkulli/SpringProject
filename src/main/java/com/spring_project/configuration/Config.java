package com.spring_project.configuration;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"com.spring_project"})
public class Config {

	@Bean(name ="emf")
	@Scope(value="prototype")
	public EntityManager getEm(){
		return Persistence.createEntityManagerFactory("project").createEntityManager();
	}
}
