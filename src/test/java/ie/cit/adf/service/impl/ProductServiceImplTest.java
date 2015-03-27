package ie.cit.adf.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import ie.cit.adf.dao.ProductRepository;
import ie.cit.adf.service.ProductService;
import ie.cit.adf.domain.Customer;
import ie.cit.adf.domain.Product;
import static org.mockito.Mockito.*;

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
		
		Product p = new Product();
		p.setId("1L");
		p.setSKU(123);
		p.setName("Trition");
		p.setDescription("Air Saw");
		p.setPricePerUnit(25.00);
		p.setStockLevel(25);
		
		List<Product> pList = new ArrayList<Product>();
		pList.add(p);
		
		when(productRepository.findAll()).thenReturn(pList);	
		
		tested.save(p);
	}

	@Test
	public void testFindAll() {
		assertEquals(1, tested.findAll().size());
	}
	
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
