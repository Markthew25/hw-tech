package com.tech.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="emp_id")
	private int empID;
	
	@NotNull(message="is required")
	@Column(name="emp_fname")
	private String empFName;
	
	@Column(name="emp_mname")
	private String empMName;
	
	@Column(name="emp_lname")
	private String empLName;
	
	@Column(name="dept_id")
	private int deptID;
	
//	@OneToMany(mappedBy="employee", cascade=CascadeType.ALL)
//	private List<Asset> assets;
	
	public Employee() {
		
	}
	
//	public List<Asset> getAssets() {
//		return assets;
//	}
//
//	public void setAssets(List<Asset> assets) {
//		this.assets = assets;
//	}

	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getEmpFName() {
		return empFName;
	}
	public void setEmpFName(String empFName) {
		this.empFName = empFName;
	}
	public String getEmpMName() {
		return empMName;
	}
	public void setEmpMName(String empMName) {
		this.empMName = empMName;
	}
	public String getEmpLName() {
		return empLName;
	}
	public void setEmpLName(String empLName) {
		this.empLName = empLName;
	}
	public int getDeptID() {
		return deptID;
	}
	public void setDeptID(int depID) {
		this.deptID = depID;
	}
	
	
}
