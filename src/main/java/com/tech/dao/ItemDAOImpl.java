package com.tech.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.tech.entity.Item;
import com.tech.entity.ItemCategory;

@Repository
public class ItemDAOImpl extends BaseDAO implements ItemDAO {

	@Override
	public List<Item> getItems() {
			
		//get the current hibernate session
//		Session currentSession = sessionFactory.getCurrentSession(); // commented out, to try BaseDAO getCurrentSession
		
		//create a query.. and sort by itemName
		Query <Item> theQuery =
				getCurrentSession().createQuery("from Item order by itemName", Item.class);
		
		//execute query and get result list
		List<Item> items = theQuery.getResultList(); 
		
		//return the results
		return items;
	}

	@Override
	public void saveItem(Item theItem) {
		
		//get current hibernate session
//		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the customer
//		currentSession.save(theItem); // we comment this out because we will use saveOrUpdate(...)
		
		//There are 2 type to save data, save(..) for new record
		//and udpate(...) for existing record
		//but in this case we will use the same method for adding and for updating
		//so we can use other method in hibernate saveOrUpdate(...)
		
		//save or update the item
		getCurrentSession().saveOrUpdate(theItem);
		
	}

	@Override
	public Item getItem(int theID) {
		
		//get the current hibernate session
//		Session currentSession = sessionFactory.getCurrentSession();
		
		//retrieve/read from database using the primary key
		Item theItem = getCurrentSession().get(Item.class, theID);
		
		return theItem;
	}

	@Override
	public void deleteItem(int theID) {
		
		//get the current hibernate session
//		Session currentSession = sessionFactory.getCurrentSession();
		
		//delete the item
		Query<?> theQuery = getCurrentSession().createQuery("delete from Item where itemID=:itemID");
		
		theQuery.setParameter("itemID", theID);
		
		theQuery.executeUpdate();
	}

	@Override
	public List<ItemCategory> getItemCats() {
		
		//get the current hibernate session
//		Session currentSession = sessionFactory.getCurrentSession(); // commented out, to try BaseDAO getCurrentSession
		
		//create a query.. and sort by itemName
		Query <ItemCategory> theQuery =
				getCurrentSession().createQuery(" from ItemCategory order by catName", ItemCategory.class);
		
		//execute query and get result list
		List<ItemCategory> cats = theQuery.getResultList(); 
		
		//return the results
		return cats;

	}

	@Override
	public Map<Integer, String> getItemCats1() {

		Map <Integer, String> catList1 = new HashMap<Integer, String>();
		
		Query<ItemCategory> theQuery =
				getCurrentSession().createQuery("from ItemCategory", ItemCategory.class);
		
		for(int i = 0; theQuery.getFetchSize() > i; i++) {
//			theQuery.getParameter(position, type)
			ItemCategory cat = new ItemCategory();
			catList1.put(cat.getCatID(), cat.getCatName());
		}
		
		return catList1;
	}


}
