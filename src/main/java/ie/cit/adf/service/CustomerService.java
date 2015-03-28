package ie.cit.adf.service;


import ie.cit.adf.domain.Customer;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public interface CustomerService {

	/**
	 * List all Customers
	 * @return list of customers
	 */
	List<Customer> findAll();
	
	/**
	 * save Customer information
	 */
	void save(Customer customer);
	
	/**
	 * List a customer by Customer ID number
	 * @param Id
	 * @return customer
	 */
	Customer getById(String Id);
		
}
