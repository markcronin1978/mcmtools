package ie.cit.adf.service;


import ie.cit.adf.domain.Customer;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public interface CustomerService {

	//List all Customers
	List<Customer> findAll();
	
	//save Customer information
	void save(Customer customer);
		
}
