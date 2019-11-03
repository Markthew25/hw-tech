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

import com.tech.entity.Brand;
import com.tech.entity.Category;
import com.tech.entity.Item;
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
	
	@GetMapping("/add-item")
	public String showAddItemForm(Model theModel) {
		
		//create model attribute
		Item theItem = new Item();
				
		List<Category> theCats = itemService.getItemCats();
		List<Brand> theBrands = itemService.getItemBrands();
		List<Supplier> theSuppliers = itemService.getItemSuppliers();
		
		theModel.addAttribute("categories", theCats);
		theModel.addAttribute("brands", theBrands);
		theModel.addAttribute("suppliers", theSuppliers);
		
		theModel.addAttribute("item", theItem);
		
		return "item-form";
	}
	
	@PostMapping("/save-item")
	public String saveItem(@Valid @ModelAttribute("item") Item theItem, 
			BindingResult theBindingResult,
			Model theModel) {
		
		List<Category> theCats = itemService.getItemCats();
		List<Brand> theBrands = itemService.getItemBrands();
		List<Supplier> theSuppliers = itemService.getItemSuppliers();
		
		theModel.addAttribute("categories", theCats);
		theModel.addAttribute("brands", theBrands);
		theModel.addAttribute("suppliers", theSuppliers);
		
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
	
	@GetMapping("/update-item")
	public String showUpdateItemForm(@RequestParam("itemID") int theID, Model theModel) {
		
		// get the item from the service
		Item theItem = itemService.getItem(theID);
		
		List<Category> theCats= itemService.getItemCats();
		List<Brand> theBrands = itemService.getItemBrands();
		List<Supplier> theSuppliers = itemService.getItemSuppliers();
		
		//set item as model attribute to prepopulate the form
		theModel.addAttribute("item", theItem);
		
		theModel.addAttribute("categories", theCats);
		theModel.addAttribute("brands", theBrands);
		theModel.addAttribute("suppliers", theSuppliers);
		
		//send over to our form
		return "item-form";
	}
	
	@GetMapping("/delete-item")
	public String deleteItem(@RequestParam("itemID") int theID) {
		
		//delete the item
		itemService.deleteItem(theID);
		
		return "redirect:/item/list";
		
	}
	
}
