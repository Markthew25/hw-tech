package com.tech.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="assets")
public class Asset {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ass_id")
	private int assID;
	
	@Column(name="item_id")
	private int itemID;
	
	@Column(name="emp_id")
	private int empID;
	
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name="emp_id")
	private Employee employee;
	
	@OneToOne(cascade= {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name="item_id")
	private Item item;
	
	public Asset() {
		
	}	
	
	public Asset(int itemID, int empID) {
		this.itemID = itemID;
		this.empID = empID;
	}
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getAssID() {
		return assID;
	}

	public void setAssID(int assID) {
		this.assID = assID;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	@Override
	public String toString() {
		return "Asset [assID=" + assID + ", itemID=" + itemID + ", empID=" + empID + ", employee=" + employee
				+ ", item=" + item + "]";
	}
	
}
