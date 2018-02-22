package org.eshop.site.web.controllers;

import java.util.List;

import org.eshop.core.catalog.CatalogService;
import org.eshop.core.entities.Category;
import org.eshop.core.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiController {
	
	    @Autowired
		private CatalogService catalogService;
		
		@RequestMapping(value="/api/allcategories", method=RequestMethod.GET)
		@ResponseBody
		public List<Category> getCategory() {
			return catalogService.getAllCategories();
		}
		
		@RequestMapping(value="/api/allproducts", method=RequestMethod.GET)
		@ResponseBody
		public List<Product> getProduct() {
			return catalogService.getAllProducts();
		}

}
