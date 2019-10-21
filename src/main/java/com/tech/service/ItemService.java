package com.tech.service;

import java.util.List;

import com.tech.entity.Item;

public interface ItemService {

	public List<Item> getItems();

	public void saveItem(Item theItem);

	public Item getItem(int theID);

	public void deleteItem(int theID);
	
}
