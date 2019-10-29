package com.tech.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
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
	
	// add an initbinder .. to convert trim input strings
	// remove leading and trailing whitespace
	// resolve issue for the validation
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		// (true) means if user input is only whitespace, it will trim all whitespace to become null
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		// apply to every String class
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		
	}
	
	
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
				
		List<ItemCategory> theCats= itemService.getItemCats();
		
		theModel.addAttribute("item", theItem);
		theModel.addAttribute("category", theCats);
		
		return "item-form";
	}
	
	@PostMapping("/saveItem")
	public String saveItem(@Valid @ModelAttribute("item") Item theItem, 
			BindingResult theBindingResult,
			Model theModel) {
		
		List<ItemCategory> theCats= itemService.getItemCats();
		theModel.addAttribute("category", theCats);
		
		//save the item using our service
		// and add validation for empty field
		
		System.out.println("Item name: |" + theItem.getItemName() + "|");
		
		System.out.println("BindingResult: " + theBindingResult);
		
		if(theBindingResult.hasErrors()) {
			return "item-form";
		}else {
			itemService.saveItem(theItem);
		}
				
		return "redirect:/item/list";
		
	}
	
	@GetMapping("/showUpdateItemForm")
	public String showUpdateItemForm(@RequestParam("itemID") int theID, Model theModel) {
		
		// get the item from the service
		Item theItem = itemService.getItem(theID);
		List<ItemCategory> theCats= itemService.getItemCats();
		
		//set item as model attribute to prepopulate the form
		theModel.addAttribute("item", theItem);
		theModel.addAttribute("category", theCats);
		
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
	
//	@ModelAttribute("categoryList")
//	public List<ItemCategory> catList(Model theModel) {
//		
//		//get customer from the item service
//		//and the item service will get data from itemDAO
//		List<ItemCategory> theCats= itemService.getItemCats();
//		
//		//add the customer to the model
////		theModel.addAttribute("cats", theCats);
//		System.out.println(theCats);
//		
//		return theCats;
//		
//	}
	
}
