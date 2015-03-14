package ie.cit.adf.service.impl;



import java.util.List;

import ie.cit.adf.dao.ProductRepository;
import ie.cit.adf.domain.Product;
import ie.cit.adf.service.SaleOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleOrderServiceImpl implements SaleOrderService {

	@Autowired
	ProductRepository pr;
	
	public List<Product> findAll(){
		return pr.findAll();
	}

	public Product getBySKU(int sku){
		return pr.getBySku(sku);
	}
	
}
