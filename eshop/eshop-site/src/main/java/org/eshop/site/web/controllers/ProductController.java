package org.eshop.site.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public String getProduct() {
		return "productdetails";
	}

}
