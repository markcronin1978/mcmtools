package ie.cit.adf.dao;

import ie.cit.adf.domain.Customer;

import java.util.List;

public interface CustomerRepository {
	
	/**
	 * List all Customers 
	 * @return list of customers
	 */
	List<Customer> findAll();
	
	/**
	 * save a new customer
	 * @param customer
	 */
	void save(Customer customer);
	
	/**
	 * return customer by email address
	 * @param email
	 * @return
	 */
	Customer getByEmailAddress(String email);
	
	/**
	 * Get a customer by Id Number
	 * @param Id
	 * @return
	 */
	Customer getById(String Id);

	/**
	 * return a list of customer by city name this was just 
	 * created for testing proposes
	 * @param city
	 * @return
	 */
	List<Customer> getByCity(String city);
	
}
