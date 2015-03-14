package ie.cit.adf.service;


import ie.cit.adf.domain.Product;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public interface SaleOrderService {
		
	List<Product> findAll();  //list all products.

	Product getBySKU(int sku);
	
}
