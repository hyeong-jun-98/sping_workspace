package com.academy.ormsqlmapapp.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ConfigManager {
	private static ConfigManager instance;
	SessionFactory sessionFactory;
	
	private ConfigManager() {
		Configuration configuration = new Configuration();
		configuration.configure("com/academy/ormsqlmapapp/hibernate/hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	

	public static ConfigManager getInstance() {
		if (instance == null) {
			instance = new ConfigManager();
		}
		return instance;
	}


}
