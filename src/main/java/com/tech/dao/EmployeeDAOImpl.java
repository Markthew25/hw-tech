package com.tech.dao;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.tech.entity.Department;
import com.tech.entity.Employee;
import com.tech.entity.Item;

@Repository
public class EmployeeDAOImpl extends BaseDAO implements EmployeeDAO {

	@Override
	public List<Employee> getEmployeeList() {
		
		//get the current hibernate session
//			Session currentSession = sessionFactory.getCurrentSession(); // commented out, to try BaseDAO getCurrentSession
		
		//create a query.. and sort by itemName
		Query <Employee> theQuery =
				getCurrentSession().createQuery("from Employee order by empLName", Employee.class);
		
		//execute query and get result list
		List<Employee> employees = theQuery.getResultList(); 
		
		//return the results
		return employees;
	}

	@Override
	public void saveEmployee(@Valid Employee theEmp) {

		getCurrentSession().saveOrUpdate(theEmp);
		
	}

	@Override
	public Employee getEmployee(int theID) {
		
		//retrieve employee from database with the ID 
		Employee theEmployee = getCurrentSession().get(Employee.class, theID);
		
		return theEmployee;
	}

	@Override
	public List<Department> getDepts() {

		//create query to get depts and sort by deptname
		Query<Department> theQuery =
				getCurrentSession().createQuery("from Department order by deptName", Department.class);
		
		//execute query and get result list
		List<Department> departments = theQuery.getResultList();
		
		return departments;
	}

	@Override
	public void deleteEmployee(int theID) {

		Employee employee = getEmployee(theID);
		
		List<Item> empItems = employee.getItems();
		
		Query<?> theQuery2 =
				getCurrentSession().createQuery("update Item set itemStatus=:itemStatus where itemID=:itemID");
		
		
		if(!empItems.isEmpty()) {
			for(int index = 0; index < empItems.size(); index++) {

				int itemAssetID = empItems.get(index).getItemID();
				
				theQuery2.setParameter("itemStatus", true);
				theQuery2.setParameter("itemID", itemAssetID );
				
				theQuery2.executeUpdate();
				
				
			}			
		}else {
			System.out.println("NO ITEMS***************");
		}
		
		Query<?> theQuery =
				getCurrentSession().createQuery("delete from Employee where empID=:empID");
 		
		theQuery.setParameter("empID", theID);
		
		theQuery.executeUpdate();
		
		
	}

	@Override
	public List<Item> getItemsAvailable() {
		
		//create query to get depts and sort by deptname
		Query<Item> theQuery =
				getCurrentSession().createQuery("from Item where itemStatus is true", Item.class);

		//execute query and get result list
		List<Item> itemsAvail = theQuery.getResultList();
	
		return itemsAvail;
	}

	@Override
	public void saveAsset(int theEmpID, int theItemID) {
		
		Employee theEmployee = getCurrentSession().get(Employee.class, theEmpID);

		theEmployee.addItem(getCurrentSession().get(Item.class, theItemID));
		
		getCurrentSession().save(theEmployee);
		
		//update the item's availability to false
		itemIsNotAvailable(theItemID);
		
	}

	@Override
	public void removeAsset(int theEmpID, int theItemID) {
		
		//get the item
		Item item = getCurrentSession().get(Item.class, theItemID);
		
		item.removeEmployee(item.getEmployee());
		
		//create query to make the item available for new custodian
		itemIsAvailable(theItemID);
		
		
		
	}

	private void itemIsAvailable(int theItemID) {
		Query<?> theQuery =
				getCurrentSession().createQuery("update Item set itemStatus=:itemStatus where itemID=:itemID");
		
		theQuery.setParameter("itemStatus", true);
		theQuery.setParameter("itemID", theItemID);
		
		theQuery.executeUpdate();
	}
	

	private void itemIsNotAvailable(int theItemID) {
		Query<?> theQuery =
				getCurrentSession().createQuery("update Item set itemStatus=:itemStatus where itemID=:itemID");
		
		theQuery.setParameter("itemStatus", false);
		theQuery.setParameter("itemID", theItemID);
		
		theQuery.executeUpdate();
	}

	//LAZY LOADING ACHIEVED!
	@Override
	public List<?> getEmployeeAssets(int theID) {

		Query<?> theQuery =
				getCurrentSession().createQuery("select e.items from "
						+ "Employee e where e.empID=:empID");
		
		theQuery.setParameter("empID", theID);
		
		List<?> empAssets = theQuery.getResultList();
		
		return empAssets;
	}

}
