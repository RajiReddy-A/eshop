package org.eshop.site.web.controllers;

import java.security.Principal;
import org.eshop.core.customers.CustomerService;
import org.eshop.core.entities.Customer;
import org.eshop.site.web.validators.CustomerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	
	//@Autowired
	//private CatalogService catalogService;
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerValidator customerValidator;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getHomePage() {
		System.out.println("inside gethomepage");
		return "homepage";
		//return catalogService.getAllCategories();
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model, String error, String logout, Principal user) {
		model.addAttribute("customer", new Customer());
		if(user != null) {
			return "redirect:/";
		}
		
		if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("logout", "You have been logged out successfully.");
        
		return "login";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String getRegistrationPage(Model model, Principal user) {
		model.addAttribute("customer", new Customer());
    	if (user != null) {
    		return "redirect:/";
    	}
		return "signup";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String submitRegistration(@ModelAttribute("customer") Customer customer, BindingResult bindingResult, 
			Model model, RedirectAttributes redirectAttrs) {
		
		customerValidator.validate(customer, bindingResult);
		if(bindingResult.hasErrors()) {
			return "redirect:/register";
		}
		
		customerService.save(customer);
		//securityService.autologin(customer.getEmail(), customer.getPassword());
		return "redirect:/login";
		
	}

}
