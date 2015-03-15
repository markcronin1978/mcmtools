package ie.cit.adf.dao;


import ie.cit.adf.domain.Product;

import java.util.List;

public interface ProductRepository {
	
	//list all products and return information in a list
	List<Product> findAll();

	//search for product by sku number and return object
	Product getBySKU(int SKU);

	//save new product
	void save(Product product);
}
