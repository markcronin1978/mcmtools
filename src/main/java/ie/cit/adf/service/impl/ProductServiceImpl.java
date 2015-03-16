package ie.cit.adf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.cit.adf.dao.ProductRepository;
import ie.cit.adf.domain.Product;
import ie.cit.adf.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	//List all Products
	public List<Product> findAll(){
		return productRepository.findAll();
	}

	//Save new product
	public void save(Product product) {
		productRepository.save(product);		
	}
	
}
