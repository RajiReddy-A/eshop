package org.eshop.site.web.controllers;

import java.util.List;

import org.eshop.core.catalog.CatalogService;
import org.eshop.core.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	//@Autowired
	//private CatalogService catalogService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getHomePage() {
		System.out.println("inside gethomepage");
		return "homepage";
		//return catalogService.getAllCategories();
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String getRegistrationPage() {
		return "signup";
	}

}
