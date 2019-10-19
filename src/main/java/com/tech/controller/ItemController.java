package com.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tech.entity.Item;
import com.tech.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {

	//need to inject the item service
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/list")
	public String listItems(Model theModel) {
		
		//get customer from the item service
		//and the item service will get data from itemDAO
		List<Item> theItems= itemService.getItems();
		
		System.out.println(theItems);
		
		//add the customer to the model
		theModel.addAttribute("items", theItems);
		
		return "list-items";
		
	}
	
	@GetMapping("/showAddItemForm")
	public String showAddItemForm(Model theModel) {
		
		//create model attribute
		Item theItem = new Item();
		
		theModel.addAttribute("item", theItem);
		
		return "item-form";
	}
	
	@PostMapping("/saveItem")
	public String saveItem(@ModelAttribute("item") Item theItem) {
		
		//save the item using our service
		itemService.saveItem(theItem);
				
		return "redirect:/item/list";
		
	}
	
}
