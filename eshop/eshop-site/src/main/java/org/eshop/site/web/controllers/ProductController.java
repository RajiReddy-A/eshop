package org.eshop.site.web.controllers;

import org.eshop.core.catalog.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {
	
	@RequestMapping(value="/product/{productname}", method=RequestMethod.GET)
	public String getProduct() {
		return "productdetails";
	}

}
