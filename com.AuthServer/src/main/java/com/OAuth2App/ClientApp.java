package com.OAuth2App;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ClientApp {

	// Home Pager --poojitha
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	//Managers Page Tables --poojitha
	@GetMapping("/leaders")
	public String leaders() {
		return "leaders";
	}
	
	//Admins Page --poojitha
	@GetMapping("/systems")
	public String systems() {
		return "systems";
	}


}
