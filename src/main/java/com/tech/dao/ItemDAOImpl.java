package com.tech.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tech.entity.Item;

@Repository
public class ItemDAOImpl implements ItemDAO {

	// need to inject the session factory

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Item> getItems() {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query <Item> theQuery =
				currentSession.createQuery("from Item", Item.class);
		
		//execute query and get result list
		List<Item> items = theQuery.getResultList(); 
		
		//return the results
		return items;
	}
	
	

}