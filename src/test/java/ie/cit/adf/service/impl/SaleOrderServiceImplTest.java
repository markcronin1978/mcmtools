package ie.cit.adf.service.impl;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.notNullValue;

import java.util.ArrayList;
import java.util.List;

import ie.cit.adf.dao.CreditCardRepository;
import ie.cit.adf.dao.CustomerRepository;
import ie.cit.adf.dao.ProductRepository;
import ie.cit.adf.dao.SaleOrderRepository;
import ie.cit.adf.domain.Customer;
import ie.cit.adf.domain.Product;
import ie.cit.adf.service.SaleOrderService;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class SaleOrderServiceImplTest {

	private SaleOrderService tested;
	private CustomerRepository customerRepository;
	private ProductRepository productRepository;
	private SaleOrderRepository saleOrderRepository;
	private CreditCardRepository creditCardRepository;
	

	@Before
	public void setup(){
		customerRepository = mock(CustomerRepository.class);
		productRepository = mock(ProductRepository.class);
		saleOrderRepository = mock(SaleOrderRepository.class);
		creditCardRepository = mock(CreditCardRepository.class);
		tested = new SaleOrderServiceImpl(productRepository, customerRepository, saleOrderRepository, creditCardRepository);
		
		/**
		 * In the setup function i am creating both a mock product and
		 * customer for testing proposes	
		 */
		Product p = new Product();
		p.setId("1L");
		p.setSKU(123);
		p.setName("Trition");
		p.setDescription("Air Saw");
		p.setPricePerUnit(25.00);
		p.setStockLevel(25);
		
		/**Add the mock product to an arrayList so that i can
		 * test the findAll products function
		 */
		List<Product> pList = new ArrayList<Product>();
		pList.add(p);
		
		/**
		 * creating different mock testing parameters for 
		 * the product repository
		 */
		when(productRepository.findAll()).thenReturn(pList);
		when(productRepository.getBySKU(123)).thenReturn(p);
		when(productRepository.getQuantityBySKU(123)).thenReturn(25);
		
		Customer c = new Customer();
		c.setId("1L");
		c.setAddress1("The Street");
		c.setAddress2("The Neighbourhood");
		c.setAddress3("Cork");
		c.setFirstName("Tom");
		c.setLastName("Hardy");
		c.setEmail("tomhardy@gmail.com");
		
		/**
		 * creating a mock parameter for testing the getbyEmailAddress
		 * in the customer repository
		 */
		when(customerRepository.getByEmailAddress("tomhardy@gmail.com")).thenReturn(c);
			
	}

	/**
	 * test the product findAll function
	 */
	@Test
	public void testFindAll() {
		assertThat(1, is(tested.findAll().size()));
		verify(productRepository).findAll();
	}
	
	/**
	 * test the product getBySKU function
	 */
	@Test
	public void testGetBySKU() {
		Product product = tested.getBySKU(123);
		product.getName();
		product.getId();
		assertThat(product.getName(), is("Trition"));
		assertThat(product.getId(), is("1L"));
		verify(productRepository).getBySKU(123);
	}

	/**
	 * test the customer getByEmailAddress
	 */
	@Test
	public void testGetByEmailAddress() {
		Customer c = tested.getByEmailAddress("tomhardy@gmail.com");
		c.getFirstName();
		c.getId();
		assertThat(c.getFirstName(), is("Tom"));
		assertThat(c.getId(), is("1L"));
		verify(customerRepository).getByEmailAddress("tomhardy@gmail.com");		
	}
	
	/**
	 * test the product getQuantityBySKU function
	 */
	@Test
	public void testGetQuantityBySKU() {	
		int id = tested.getQuantityBySKU(123);
		assertThat(id, is(25));
		verify(productRepository).getQuantityBySKU(123);
	}

}
