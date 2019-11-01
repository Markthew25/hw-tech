package com.tech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "items")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private int itemID;

	@NotNull(message="is required")
	@Size(min=1, message="is required") 
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
	
	@Max(value=1000, message="must be less than or equal to 1000")
	@Min(value=10, message="must be greater than or equal to 10")
	@NotNull(message="is required")
	
	@Column(name = "item_qty")
	private Integer itemQty;

//	@ManyToOne(
//			cascade= {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
//	@JoinTable(
//			name="assets",
//			joinColumns=@JoinColumn(name="item_id"),
//			inverseJoinColumns=@JoinColumn(name="emp_id")
//			)
//	private List<Employee> employees;
		
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
		this.itemName = itemName;
	}

	public Boolean getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(Boolean itemStatus) {
		this.itemStatus = itemStatus;
	}

	public Integer getItemQty() {
		return itemQty;
	}

	public void setItemQty(Integer itemQty) {
		this.itemQty = itemQty;
	}
	
//	//convience method
//		public void addItem(Employee theEmployee) {
//			if(employees==null) {
//				employees = new ArrayList<Employee>();
//			}
//			
//			employees.add(theEmployee);
//			
//		}

	@Override
	public String toString() {
		return "Item [itemID=" + itemID + ", itemName=" + itemName + ", catID=" + catID + ", brandID=" + brandID
				+ ", suppID=" + suppID + ", itemStatus=" + itemStatus + ", itemQty=" + itemQty + "]";
	}

	

}
