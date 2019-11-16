package com.tech.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tech.entity.Brand;
import com.tech.entity.Category;
import com.tech.entity.Item;
import com.tech.entity.OS;
import com.tech.entity.Supplier;
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
	
//	@InitBinder
//	public void initBinder(WebDataBinder dataBinder) {
//		
//		// (true) means if user input is only whitespace, it will trim all whitespace to become null
//		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
//		
//		// apply to every String class
//		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
//	}
	
	
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
	
	@GetMapping("/add-peripheral")
	public String showAddItemForm(Model theModel) {
		
		//create model attribute
		Item theItem = new Item();
				
		comboBoxes(theModel);
		
		theModel.addAttribute("item", theItem);
		
		return "item-form-peripheral";
		
	}
	
	@GetMapping("/add-os")
	public String showAddOS(Model theModel) {
		
		OS os = new OS();
		theModel.addAttribute("item", os);
				
		comboBoxes(theModel);
		
		return "item-form-os";
	}
	
	@PostMapping("/save-item-peripheral")
	public String saveItem(@Valid @ModelAttribute("item") Item theItem, 
			BindingResult theBindingResult,
			Model theModel) {
		

		List<Category> theCats = itemService.getItemCats();
		
		List<Brand> theBrands = itemService.getItemBrands();
		List<Supplier> theSuppliers = itemService.getItemSuppliers();
		
		theModel.addAttribute("categories", theCats);
		theModel.addAttribute("brands", theBrands);
		theModel.addAttribute("suppliers", theSuppliers);

		comboBoxes(theModel);
		
		//save the item using our service
		// and add validation for empty field
	
		System.out.println("BindingResult: " + theBindingResult);
		
		if(theBindingResult.hasErrors()) {
			return "item-form-peripheral";
		}else {
			itemService.saveItem(theItem);
		}
				
		return "redirect:/item/list";
		
	}
	
	@PostMapping("/save-item-os")
	public String saveItem(@Valid @ModelAttribute("item") OS os, 
			BindingResult theBindingResult,
			Model theModel) {
		
		comboBoxes(theModel);
		
		//save the item using our service
		// and add validation for empty field
	
		System.out.println("BindingResult: " + theBindingResult);
		
		if(theBindingResult.hasErrors()) {
			return "item-form-os";
		}else {
			itemService.saveItem(os);
		}
				
		return "redirect:/item/list";
		
	}
	
	@GetMapping("/update-item")
	public String showUpdateItemForm(@RequestParam("itemID") int theID, Model theModel) {
		
		// get the item from the service
		Item theItem = itemService.getItem(theID);
		
		comboBoxes(theModel);
		
		if (theItem.getItemType().equals("O")) {
			OS os = (OS) itemService.getItem(theID);
			theModel.addAttribute("item", os);
			return "item-form-os";
		}else if (theItem.getItemType().equals("P")) {
			//set item as model attribute to prepopulate the form
			theModel.addAttribute("item", theItem);
			return "item-form-peripheral";
		}else {
			return "list-items";
		}
	}
	
	@GetMapping("/delete-item")
	public String deleteItem(@RequestParam("itemID") int theID) {
		
		//delete the item
		itemService.deleteItem(theID);
		
		return "redirect:/item/list";
		
	}
	
	private void comboBoxes(Model theModel) {
		List<Category> theCats = itemService.getItemCats();
		List<Brand> theBrands = itemService.getItemBrands();
		List<Supplier> theSuppliers = itemService.getItemSuppliers();
		
		theModel.addAttribute("categories", theCats);
		theModel.addAttribute("brands", theBrands);
		theModel.addAttribute("suppliers", theSuppliers);
	}
	
}
