package com.tech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login() {
		return "hwtech-login";
	} 
	
	@GetMapping("/home")
	public String homePage() {
		return "home";
	}
	
	
}
