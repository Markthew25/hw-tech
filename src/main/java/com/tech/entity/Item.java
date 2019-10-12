package com.tech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private int itemID;

	@Column(name = "item_name")
	private String itemName;
	@Column(name = "item_status")
	private String itemStatus;
	@Column(name = "item_qty")
	private int itemQty;

	public Item() {

	}

	public Item(String itemName, String itemStatus, int itemQty) {
		this.itemName = itemName;
		this.itemStatus = itemStatus;
		this.itemQty = itemQty;
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

	public String getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}

	public int getItemQty() {
		return itemQty;
	}

	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}

	@Override
	public String toString() {
		return "Item [itemID=" + itemID + ", itemName=" + itemName + ", itemStatus=" + itemStatus + ", itemQty="
				+ itemQty + "]";
	}

}
