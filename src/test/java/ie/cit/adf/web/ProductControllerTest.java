package ie.cit.adf.web;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import ie.cit.adf.domain.Product;
import ie.cit.adf.service.ProductService;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.validation.BindingResult;

public class ProductControllerTest {

	private ProductService productService;
	private ProductController tested;
	private ExtendedModelMap model;
	
	
	@Before
	public void setup(){
		productService = mock(ProductService.class);
		tested = new ProductController(productService);
		model = new ExtendedModelMap();
		BindingResult result = mock(BindingResult.class);
		
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
		 * I am declaring that when the save function is called, the mock product will be save. 
		 */
		tested.save(p, result, model);
		
	}
	
	/**
	 * test the correct view is being returned and the the 
	 * product list coming into the method is not null
	 * @throws Exception
	 */
	@Test
	public void testListProducts() throws Exception{
		String view = tested.listProducts(model);
		assertThat(view, CoreMatchers.equalTo("productList"));
		assertThat(model.get("products"), notNullValue());
		verify(productService).findAll();
	}
	
	/**
	 * test that the correct view is being returned from the
	 *  method.
	 * @throws Exception
	 */
	@Test
	public void testFormProduct() throws Exception{
		String view = tested.formProduct(model);
		assertThat(view, CoreMatchers.equalTo("productForm"));
	}
	
	/**
	 * test the method to save a new product. 
	 * test the javax validator	
	 */
	@Test
	public void testSave(){
		
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();	
		
		Set<ConstraintViolation<Product>> constraintViolations = validator.validateValue(Product.class, "name", "Trition");
		assertEquals(0, constraintViolations.size());
		
		Mockito.verify(productService).save(Mockito.argThat(new ArgumentMatcher<Product>(){
			@Override
			public boolean matches(Object argument){
				return ((Product) argument).getName().equals("Trition");
			}
		}));
	}
}
