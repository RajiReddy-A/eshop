package org.eshop.core.customers;

import java.util.List;

import javax.transaction.Transactional;

import org.eshop.core.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service()
@Transactional
public class CustomerService {
	@Autowired 
	private CustomerRepository customerRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public Customer getCustomerByEmail(String email) {
		return customerRepository.findByEmail(email);
	}

	public void save(Customer customer) {
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		customerRepository.save(customer);
	}
}
