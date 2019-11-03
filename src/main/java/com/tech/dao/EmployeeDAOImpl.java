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
		
		//retrieve employee from database
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
		
		Query<?> theQuery =
				getCurrentSession().createQuery("delete from Employee where empID=:empID");
 		
		theQuery.setParameter("empID", theID);
		
		theQuery.executeUpdate();
		
	}

	@Override
	public List<Item> getEmpAssets(int theID) {
		
		//retrieve employee from database
		Employee theEmployee = getCurrentSession().get(Employee.class, theID);
		
		//get the assets from the employee
		List<Item> empAssets = theEmployee.getItems();

		return empAssets;
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
		Item theItem = getCurrentSession().get(Item.class, theItemID);
		
		theEmployee.addItem(theItem);
		
		getCurrentSession().save(theEmployee);
		
		//update the item's availability to false
		Query<?> theQuery =
				getCurrentSession().createQuery("update Item set itemStatus=:itemStatus where itemID=:itemID");
		
		theQuery.setParameter("itemStatus", false);
		theQuery.setParameter("itemID", theItemID);
		
		theQuery.executeUpdate();
		
	}

	@Override
	public void removeAsset(int theEmpID, int theItemID) {
		
		//get the item
		Item item = getCurrentSession().get(Item.class, theItemID);
		
		//get the custodian of the item
		Employee employee = item.getEmployee();
		
		//get the all the custodians Item
		List<Item> items = employee.getItems();
		
		//remove the item from custodians Item
		items.remove(item);
		
		//create query to make the item available for new custodian
		Query<?> theQuery =
				getCurrentSession().createQuery("update Item set itemStatus=:itemStatus where itemID=:itemID");
		
		theQuery.setParameter("itemStatus", true);
		theQuery.setParameter("itemID", theItemID);
		
		theQuery.executeUpdate();
		
	}

}
