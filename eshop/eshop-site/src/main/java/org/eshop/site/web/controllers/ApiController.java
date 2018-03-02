package org.eshop.site.web.controllers;

import java.util.List;

import org.eshop.core.catalog.CatalogService;
import org.eshop.core.customers.CustomerService;
import org.eshop.core.entities.Category;
import org.eshop.core.entities.Customer;
import org.eshop.core.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiController {
	
	    @Autowired
		private CatalogService catalogService;
	    
	    @Autowired
	    private CustomerService customerService;
		
		@RequestMapping(value="/api/allcategories", method=RequestMethod.GET)
		@ResponseBody
		public List<Category> getCategories() {
			return catalogService.getAllCategories();
		}
		
		@RequestMapping(value="/api/allproducts", method=RequestMethod.GET)
		@ResponseBody
		public List<Product> getProducts() {
			return catalogService.getAllProducts();
		}
		
		@RequestMapping(value="/api/allcustomers", method=RequestMethod.GET)
		@ResponseBody
		public List<Customer> getCustomers() {
			return customerService.getAllCustomers();
		}
		
		@RequestMapping(value="/api/customer/{email:.+}")
		@ResponseBody
		public Customer getCustomer(@PathVariable String email) {
			System.out.println(email);
			System.out.println(customerService.getCustomerByEmail(email));
			return customerService.getCustomerByEmail(email);
		}
		
		@RequestMapping(value="/api/product/{product}")
		@ResponseBody
		public Product getProduct(@PathVariable String product) {
			return catalogService.getProduct(product);
		}

}
