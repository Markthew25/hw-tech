package com.tech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tech.dao.ItemDAO;
import com.tech.entity.Item;

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

}
