package com.tech.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tech.entity.Item;
import com.tech.entity.ItemCategory;
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
	
	@GetMapping("/showUpdateItemForm")
	public String showUpdateItemForm(@RequestParam("itemID") int theID, Model theModel) {
		
		// get the item from the service
		Item theItem = itemService.getItem(theID);
		
		//set item as model attribute to prepopulate the form
		theModel.addAttribute("item", theItem);
		
		//send over to our form
		return "item-form";
	}
	
	@GetMapping("/delete")
	public String deleteItem(@RequestParam("itemID") int theID) {
		
		//delete the item
		itemService.deleteItem(theID);
		
		return "redirect:/item/list";
		
	}
	
//	@ModelAttribute("categoryList")
//	   public List<String> getNumbersList() {
//	      List<String> catList = new ArrayList<String>();
//	      catList.add("Mouse");
//	      catList.add("Keyboard");
//	      catList.add("Operating System");
//	      catList.add("Others");
//	      return catList;
//	}
	
	@ModelAttribute("categoryList")
	public List<ItemCategory> catList(Model theModel) {
		
		//get customer from the item service
		//and the item service will get data from itemDAO
		List<ItemCategory> theCats= itemService.getItemCats();
		
		//add the customer to the model
//		theModel.addAttribute("cats", theCats);
		System.out.println(theCats);
		
		return theCats;
		
	}
	
	@ModelAttribute("categoryList1")
	public Map<Integer, String> catList1(Model theModel) {
		
		//get customer from the item service
		//and the item service will get data from itemDAO
		Map<Integer, String> theCats= itemService.getItemCats1();
		
		//add the customer to the model
//		theModel.addAttribute("cats", theCats);
		System.out.println(theCats);
		
		return theCats;
		
	}
	
}
