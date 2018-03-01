package org.eshop.site.web.validators;

import org.eshop.core.customers.CustomerService;
import org.eshop.core.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CustomerValidator implements Validator{
	
	@Autowired
	private CustomerService customerService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Customer.class.isAssignableFrom(clazz);
	}

	 @Override
	    public void validate(Object o, Errors errors) {
	        Customer customer = (Customer) o;
	
	        Customer customerByEmail = customerService.getCustomerByEmail(customer.getEmail());
			if(customerByEmail != null){
				errors.rejectValue("email", "error.exists", new Object[]{customer.getEmail()}, "Email "+customer.getEmail()+" already in use");
			}
	    }
}
