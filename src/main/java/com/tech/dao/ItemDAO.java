package com.tech.dao;

import java.util.List;
import java.util.Map;

import com.tech.entity.Item;
import com.tech.entity.ItemCategory;

public interface ItemDAO {

	public List<Item> getItems();

	public void saveItem(Item theItem);

	public Item getItem(int theID);

	public void deleteItem(int theID);

	public List<ItemCategory> getItemCats();

	public Map<Integer, String> getItemCats1();
	
}
