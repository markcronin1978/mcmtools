package ie.cit.adf.service.impl;



import java.util.List;

import ie.cit.adf.dao.CreditCardRepository;
import ie.cit.adf.dao.CustomerRepository;
import ie.cit.adf.dao.ProductRepository;
import ie.cit.adf.dao.SaleOrderRepository;
import ie.cit.adf.domain.CreditCard;
import ie.cit.adf.domain.Customer;
import ie.cit.adf.domain.Product;
import ie.cit.adf.domain.SaleOrder;
import ie.cit.adf.service.SaleOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleOrderServiceImpl implements SaleOrderService {
	
	private ProductRepository productRepository;
	private CustomerRepository customerRepository;
	private SaleOrderRepository saleOrderRepository;
	private CreditCardRepository creditCardRepository;
	
	@Autowired
	public SaleOrderServiceImpl(ProductRepository productRepository, CustomerRepository customerRepository, 
			SaleOrderRepository saleOrderRepository, CreditCardRepository creditCardRepository){
		this.customerRepository = customerRepository;
		this.productRepository = productRepository;
		this.saleOrderRepository = saleOrderRepository;
		this.creditCardRepository = creditCardRepository;
	}
	
	/**
	 * list all products
	 */
	public List<Product> findAll(){
		return productRepository.findAll();
	}

	/**
	 * list product with specific sku number
	 */
	public Product getBySKU(int sku){
		return productRepository.getBySKU(sku);
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
		return productRepository.getQuantityBySKU(productSKU);
	}
	
	/**
	 * return a list of previously purchased products
	 */
	public List<SaleOrder> purchaseHist(String name) {
		return saleOrderRepository.purchaseHist(name);
	}

	public CreditCard getbyEmailAddress(String email) {
		return creditCardRepository.getbyEmailAddress(email);
	}

	public void save(CreditCard creditCard) {
		creditCardRepository.save(creditCard);		
	}
	
	public void save(Product product){
		productRepository.save(product);
	}

	public void save(SaleOrder saleOrder) {
		saleOrderRepository.save(saleOrder);		
	}
	
}
