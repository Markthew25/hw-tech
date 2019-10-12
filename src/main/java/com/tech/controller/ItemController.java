package com.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tech.dao.ItemDAO;
import com.tech.entity.Item;

@Controller
@RequestMapping("/item")
public class ItemController {

	//need to inject the item dao
	@Autowired
	private ItemDAO itemDAO;
	
	@RequestMapping("/list")
	public String listItems(Model theModel) {
		
		//get customer from the dao
		List<Item> theItems=itemDAO.getItems();
		
		System.out.println(theItems);
		
		//add the customer to the model
		theModel.addAttribute("items", theItems);
		
		return "list-items";
		
	}
	
}
