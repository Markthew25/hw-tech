package com.tech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HWTechController {

	@GetMapping("/")
	public String showHome() {
		return "index";
	}
	
	//add request mapping for /leaders
	@GetMapping("/leaders")
	public String showLeaders() {
		return "leaders";
	}
	
}
