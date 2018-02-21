package org.eshop.core.customers;

import java.util.List;

import javax.transaction.Transactional;

import org.eshop.core.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomerService {
	@Autowired CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

}
