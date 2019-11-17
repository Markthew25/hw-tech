package com.tech.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.tech.entity.Brand;
import com.tech.entity.Category;
import com.tech.entity.Item;
import com.tech.entity.Supplier;

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

//		if(theItem.getItemStatus().equals(true)) {
//			theItem.getEmployee().getItems().remove(theItem);
//		}
		
		//get employee from item
		
//		Query<?> query = getCurrentSession().createQuery("select i.employee "
//				+ "from Item i where i.itemID=:itemID");
//		
//		query.setParameter("itemID", theItem.getItemID());
//		
//		Object emp = (Employee)query.getSingleResult();
//	
//		getCurrentSession().saveOrUpdate(theItem);
		
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
		
//		System.out.println("CUSTODIAN NAME = " + theItem.getEmployee().getEmpFName());
		
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
	public List<Category> getItemCats() {
		
		//get the current hibernate session
//		Session currentSession = sessionFactory.getCurrentSession(); // commented out, to try BaseDAO getCurrentSession
		
		//create a query.. and sort by itemName
		Query <Category> theQuery =
				getCurrentSession().createQuery(" from Category order by catName", Category.class);
		
		//execute query and get result list
		List<Category> cats = theQuery.getResultList(); 
		
		//return the results
		return cats;

	}

	@Override
	public List<Brand> getItemBrands() {
		
		Query <Brand> theQuery =
				getCurrentSession().createQuery(" from Brand order by brandName", Brand.class);
		
		//execute query and get result list
		List<Brand> brands = theQuery.getResultList(); 

		return brands;
	}

	@Override
	public List<Supplier> getItemSuppliers() {

		Query <Supplier> theQuery =
				getCurrentSession().createQuery(" from Supplier order by suppName", Supplier.class);
		
		//execute query and get result list
		List<Supplier> supps = theQuery.getResultList(); 

		return supps;
	}

}
