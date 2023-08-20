package com.OAuth2App;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResourceServer {
	
	//Display Login Form --poojitha
	
	@GetMapping("/showMyLoginPage")
	public String showLoginPage() {
		
		return "fancy-login";
	}
	
	//Error Page for unauth people --poojitha
	
	@GetMapping("/access-denied")
	public String accessdenied() {
		return "access-denied";
	}


}
