package ie.cit.adf.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import ie.cit.adf.dao.ProductRepository;
import ie.cit.adf.service.ProductService;

import ie.cit.adf.domain.Product;
import static org.mockito.Mockito.*;
import static org.hamcrest.core.Is.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;

public class ProductServiceImplTest {
	
	private ProductService tested;
	private ProductRepository productRepository;
	
	@Before
	public void setup(){
		productRepository = mock(ProductRepository.class);
		tested = new ProductServiceImpl(productRepository);
		
		/**
		 * I am creating a mock product to use for testing functions
		 */
		Product p = new Product();
		p.setId("1L");
		p.setSKU(123);
		p.setName("Trition");
		p.setDescription("Air Saw");
		p.setPricePerUnit(25.00);
		p.setStockLevel(25);
		
		/**
		 * I am adding to product to a list so that i 
		 * can test the findAll method which requires a list to be returned
		 */
		List<Product> pList = new ArrayList<Product>();
		pList.add(p);

		/**
		 * I am declaring here that when a the find all Product method is called
		 * then the mock testing should return the arraylist i created above
		 * which contains a single product									
		 */
		when(productRepository.findAll()).thenReturn(pList);
		
		tested.save(p);
	}

	/**
	 * method to test list all products function.
	 */
	@Test
	public void testFindAll() {
		assertThat(1, is(tested.findAll().size()));
		verify(productRepository).findAll();
	}
	
	/**
	 * method to test save product function
	 */	
	@Test
	public void testSave(){			
		Mockito.verify(productRepository).save(Mockito.argThat(new ArgumentMatcher<Product>(){
			@Override
			public boolean matches(Object argument){
				return ((Product) argument).getName().equals("Trition");
			}
		}));
	}

}
