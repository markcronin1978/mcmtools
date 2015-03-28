package ie.cit.adf.service.impl;



import java.util.List;

import ie.cit.adf.dao.CustomerRepository;
import ie.cit.adf.dao.ProductRepository;
import ie.cit.adf.domain.Customer;
import ie.cit.adf.domain.Product;
import ie.cit.adf.service.SaleOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleOrderServiceImpl implements SaleOrderService {
	
	private ProductRepository producRepository;
	private CustomerRepository customerRepository;
	
	@Autowired
	public SaleOrderServiceImpl(ProductRepository producRepository, CustomerRepository customerRepository){
		this.customerRepository = customerRepository;
		this.producRepository = producRepository;
	}
	
	/**
	 * list all products
	 */
	public List<Product> findAll(){
		return producRepository.findAll();
	}

	/**
	 * list product with specific sku number
	 */
	public Product getBySKU(int sku){
		return producRepository.getBySKU(sku);
	}

	/**
	 * search for customer by email address
	 */
	public Customer getByEmailAddress(String email) {
		return customerRepository.getByEmailAddress(email);
	}
	
	/**
	 * search for quantity of product by product SKU number.
	 */
	public int getQuantityBySKU(int productSKU) {
		return producRepository.getQuantityBySKU(productSKU);
	}
	
}
