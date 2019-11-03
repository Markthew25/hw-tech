package com.tech.dao;

import java.util.List;

import com.tech.entity.Item;
import com.tech.entity.Category;

public interface ItemDAO {

	public List<Item> getItems();

	public void saveItem(Item theItem);

	public Item getItem(int theID);

	public void deleteItem(int theID);

	public List<Category> getItemCats();

}
