package ie.cit.adf.service;


import ie.cit.adf.domain.Customer;
import ie.cit.adf.domain.Product;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public interface SaleOrderService {
	
	//list all products.
	List<Product> findAll();  

	//list product with specific sku number
	Product getBySKU(int sku);

	//get customer information by email address
	Customer getByEmailAddress(String email);
	
	//get quantity of product by SKU number
	int getQuantityBySKU(int productSKU);
	
	
	
}
