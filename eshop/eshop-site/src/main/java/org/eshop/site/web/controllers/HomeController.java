package org.eshop.site.web.controllers;

import java.util.List;

import org.eshop.core.catalog.CatalogService;
import org.eshop.core.entities.Category;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	private CatalogService catalogService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	@ResponseBody
	public List<Category> getHomePage() {
		return catalogService.getAllCategories();
	}

}
