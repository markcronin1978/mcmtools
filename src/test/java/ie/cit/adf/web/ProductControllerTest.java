package ie.cit.adf.web;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import ie.cit.adf.service.ProductService;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;

public class ProductControllerTest {

	private ProductService ps;
	private ProductController tested;
	private ExtendedModelMap model;
	
	
	@Before
	public void setup(){
		ps = mock(ProductService.class);
		tested = new ProductController(ps);
		model = new ExtendedModelMap();
		
	}
	
	//test the correct view is being returned and the the product list coming into the method is not null
	@Test
	public void testListProducts() throws Exception{
		String view = tested.listProducts(model);
		assertThat(view, CoreMatchers.equalTo("productList"));
		assertThat(model.get("products"), notNullValue());
		verify(ps).findAll();
	}
	
	//test that the correct view is being returned from the method.
	@Test
	public void testFormProduct() throws Exception{
		String view = tested.formProduct(model);
		assertThat(view, CoreMatchers.equalTo("productForm"));
	}
	
}
