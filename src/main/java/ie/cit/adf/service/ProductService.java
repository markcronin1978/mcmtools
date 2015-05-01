package ie.cit.adf.service;

import ie.cit.adf.domain.Product;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public interface ProductService {

	/**
	 * List all Products
	 * @return list of products
	 */
	List<Product> findAll();

	/**
	 * save product 
	 * @param product
	 */
	void save(Product product);
	
	/**
	 * Return product by SKU number
	 * @param SKU
	 * @return
	 */
	Product getBySKU(int SKU);

}
