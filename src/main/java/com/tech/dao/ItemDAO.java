package com.tech.dao;

import java.util.List;

import com.tech.entity.Item;

public interface ItemDAO {

	public List<Item> getItems();

	public void saveItem(Item theItem);

	public Item getItem(int theID);

	public void deleteItem(int theID);
	
}
