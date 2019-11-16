package com.tech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HWTechController {

	@GetMapping("/")
	public String showHome() {
		return "index";
	}
	
	@GetMapping("/home2")
	public String showHome2() {
		return "index2";
	}
	
	//add request mapping for /leaders
	@GetMapping("/leaders")
	public String showLeaders() {
		return "leaders";
	}
	
	//add request mapping for /systems
		@GetMapping("/systems")
		public String showSystems() {
			return "systems";
		}
		
	
}
