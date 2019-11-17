package com.tech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tech.dao.ItemDAO;
import com.tech.entity.Item;
import com.tech.entity.Supplier;
import com.tech.entity.Brand;
import com.tech.entity.Category;

@Service
public class ItemServiceImpl implements ItemService {

	//need to inject item DAO
	@Autowired
	private ItemDAO itemDAO;
	
	@Override
	@Transactional
	public List<Item> getItems() {
		return itemDAO.getItems();
	}

	@Override
	@Transactional
	public void saveItem(Item theItem) {	
		itemDAO.saveItem(theItem);
	}

	@Override
	@Transactional
	public Item getItem(int theID) {
		return itemDAO.getItem(theID);
	}

	@Override
	@Transactional
	public void deleteItem(int theID) {
		itemDAO.deleteItem(theID);	
	}

	@Override
	@Transactional
	public List<Category> getItemCats() {
		return itemDAO.getItemCats();
	}

	@Override
	@Transactional
	public List<Brand> getItemBrands() {
		return itemDAO.getItemBrands();
	}

	@Override
	@Transactional
	public List<Supplier> getItemSuppliers() {
		return itemDAO.getItemSuppliers();
	}

}
