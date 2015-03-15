package ie.cit.adf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.cit.adf.dao.CustomerRepository;
import ie.cit.adf.domain.Customer;
import ie.cit.adf.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;

	//list all customers and return in list
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	//save a new customer
	public void save(Customer customer) {
		customerRepository.save(customer);		
	}

}
