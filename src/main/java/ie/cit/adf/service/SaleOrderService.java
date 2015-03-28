package ie.cit.adf.service;


import ie.cit.adf.domain.Customer;
import ie.cit.adf.domain.Product;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public interface SaleOrderService {
	
	/**
	 * list all products
	 * @return a list of products
	 */
	List<Product> findAll();  

	/**
	 * get product by SKU number
	 * @param sku
	 * @return a specific product object
	 */
	Product getBySKU(int sku);

	/**
	 * get customer by email address
	 * @param email
	 * @return a specific customer object
	 */
	Customer getByEmailAddress(String email);
	
	/**
	 * get quantity amount of a specific product using the product SKU number
	 * @param productSKU
	 * @return
	 */
	int getQuantityBySKU(int productSKU);
	
	
	
}
