package com.tech.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseDAO {
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getCurrentSession() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		return currentSession;
	}

}
