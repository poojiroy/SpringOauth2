package com.OAuth2App;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ClientApp {
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	@GetMapping("/leaders")
	public String leaders() {
		return "leaders";
	}
	
	@GetMapping("/systems")
	public String systems() {
		return "systems";
	}


}
