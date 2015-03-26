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

	
	private ProductRepository pr;
	private CustomerRepository cr;
	
	@Autowired
	public SaleOrderServiceImpl(ProductRepository pr, CustomerRepository cr){
		this.cr = cr;
		this.pr = pr;
	}
	//list all products
	public List<Product> findAll(){
		return pr.findAll();
	}

	//list product with specific sku number
	public Product getBySKU(int sku){
		return pr.getBySKU(sku);
	}

	public Customer getByEmailAddress(String email) {
		return cr.getByEmailAddress(email);
	}
	public int getQuantityBySKU(int productSKU) {
		return pr.getQuantityBySKU(productSKU);
	}
	
}
