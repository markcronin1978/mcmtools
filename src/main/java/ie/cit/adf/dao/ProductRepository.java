package ie.cit.adf.dao;


import ie.cit.adf.domain.Product;

import java.util.List;

public interface ProductRepository {
	
	/**
	 * list all products and return information in a list
	 * @return product arrayList
	 */
	List<Product> findAll();

	/**
	 * search for product by sku number and return object
	 * @param SKU
	 * @return a product object
	 */
	Product getBySKU(int SKU);

	/**
	 * save new product
	 * @param product
	 */
	void save(Product product);

	/**
	 * return quantity of product by SKU number
	 * @param productSKU
	 * @return a product object
	 */
	int getQuantityBySKU(int productSKU);
}
