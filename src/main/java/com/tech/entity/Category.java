package com.tech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Category{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cat_id")
	private int catID;
	
	@Column(name = "cat_name")
	private String catName;
	
	public Category() {
		
	}

	public Category(String catName) {
		this.catName = catName;
	}

	public String getCatName() {
		return catName;
	}

	public int getCatID() {
		return catID;
	}

	public void setCatID(int catID) {
		this.catID = catID;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

//	@Override
//	public String toString() {
//		return catID + catName;
//	}
	
	
	
}
