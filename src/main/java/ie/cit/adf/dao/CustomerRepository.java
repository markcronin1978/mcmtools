package ie.cit.adf.dao;

import ie.cit.adf.domain.Customer;

import java.util.List;

public interface CustomerRepository {
	
	//List all Customers
	List<Customer> findAll();
	
	//save a new customer
	void save(Customer customer);
	
	//return customer by email address
	Customer getByEmailAddress(String email);
	
}
