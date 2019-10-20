package com.tech.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tech.entity.Item;

@Repository
public class ItemDAOImpl implements ItemDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Item> getItems() {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query.. and sort by itemName
		Query <Item> theQuery =
				currentSession.createQuery("from Item order by itemName", Item.class);
		
		//execute query and get result list
		List<Item> items = theQuery.getResultList(); 
		
		//return the results
		return items;
	}

	@Override
	public void saveItem(Item theItem) {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the customer
//		currentSession.save(theItem); // we comment this out because we will use saveOrUpdate(...)
		
		//There are 2 type to save data, save(..) for new record
		//and udpate(...) for existing record
		//but in this case we will use the same method for adding and for updating
		//so we can use other method in hibernate saveOrUpdate(...)
		
		//save or update the item
		currentSession.saveOrUpdate(theItem);
		
	}

	@Override
	public Item getItem(int theID) {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//retrieve/read from database using the primary key
		Item theItem = currentSession.get(Item.class, theID);
		
		return theItem;
	}

	@Override
	public void deleteItem(int theID) {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//delete the item
		Query theQuery = currentSession.createQuery("delete from Item where itemID=:itemID");
		
		theQuery.setParameter("itemID", theID);
		
		theQuery.executeUpdate();
	}

	

}
