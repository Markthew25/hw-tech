package com.tech.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "items")
@DiscriminatorColumn(name="item_type", discriminatorType=DiscriminatorType.STRING)
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private int itemID;

	@NotBlank(message="is required")
	@Column(name = "item_name")
	private String itemName;

	@Column(name = "cat_id")
	private int catID;
	
	@Column(name = "brand_id")
	private int brandID;
	
	@Column(name = "supp_id")
	private int suppID;

	@Column(name = "item_status")
	private Boolean itemStatus;
	
	@Column(name="item_type",insertable=false, updatable=false)
	private String itemType;

	@ManyToOne(fetch=FetchType.LAZY,
			cascade= {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(
			name="assets",
			joinColumns=@JoinColumn(name="item_id", insertable=false, updatable=false),
			inverseJoinColumns=@JoinColumn(name="emp_id", insertable=false, updatable=false)	
			)
	private Employee employee;
		
	public Item() {

	}

	public int getCatID() {
		return catID;
	}

	public void setCatID(int catID) {
		this.catID = catID;
	}

	public int getBrandID() {
		return brandID;
	}

	public void setBrandID(int brandID) {
		this.brandID = brandID;
	}

	public int getSuppID() {
		return suppID;
	}

	public void setSuppID(int suppID) {
		this.suppID = suppID;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName.trim();
	}

	public Boolean getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(Boolean itemStatus) {
		this.itemStatus = itemStatus;
	}
	
	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public Employee getEmployee() {
		return employee;
	}

	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public void removeEmployee(Employee theEmployee) {
		
		theEmployee.getItems().remove(this);
		
	}
	
	@Override
	public String toString() {
		return "Item [itemID=" + itemID + ", itemName=" + itemName + ", catID=" + catID + ", brandID=" + brandID
				+ ", suppID=" + suppID + ", itemStatus=" + itemStatus + "]";
	}
	

}
