package ie.cit.adf.web;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ie.cit.adf.domain.Customer;
import ie.cit.adf.domain.Product;
import ie.cit.adf.service.SaleOrderService;









import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.remoting.soap.SoapFaultException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ExtendedModelMap;


public class SaleOrderControllerTest {
	
	private SaleOrderService ss;
	private SaleOrderController tested;
	private ExtendedModelMap model;
	//private Authentication auth;
	
	
	@Before
	public void setup(){
		ss = mock(SaleOrderService.class);
		//auth = SecurityContextHolder.getContext().getAuthentication();
		tested = new SaleOrderController(ss);
		model = new ExtendedModelMap();
		
				
		/**
		 * This is a mock product so that function that are contained with the SaleOrderController can
		 * be tested
		 */
		Product p = new Product();
		p.setId("1L");
		p.setSKU(123);
		p.setName("Trition");
		p.setDescription("Air Saw");
		p.setPricePerUnit(25.00);
		p.setStockLevel(25);
		
		/**
		 * Adding above mock Product to an ArrayList.
		 */
		List<Product> pList = new ArrayList<Product>();
		pList.add(p);
		
		/**
		 * Mock Customer required to test quantity method within SaleOrderController
		 */
		Customer c = new Customer();
		c.setId("1L");
		c.setAddress1("The Street");
		c.setAddress2("The Neighbourhood");
		c.setAddress3("Cork");
		c.setFirstName("Tom");
		c.setLastName("Hardy");
		c.setEmail("tomhardy@gmail.com");
		c.setPassword("password");
		
		/**
		 * This is setup to verify that the ListProduct Method is returning a array list
		 * which contains the product created above.
		 */
		when(ss.findAll()).thenReturn(pList);
		
		/**
		 * This is setup so that when the function SaleOrderService.getBySKU is called 
		 * it will return the product created above
		 */
		when(ss.getBySKU(123)).thenReturn(p);
		
		/**
		 * This is setup to create a instance of a SaleOrder so that the quantity check in
		 * the Quantity method can be tested effectively
		 */
		tested.so.setProductSKU(123);
			
		/**
		 * Here i am saying that when the saleOrderServices called the getByEmailAddress function, then
		 * return the mock customer above. 
		 */
		ss.getByEmailAddress("tomhardy@gmail.com");
		
		tested.so.setCustomerEmail("tomhardy@gmail.com");
		
		when(ss.getByEmailAddress("tomhardy@gmail.com")).thenReturn(c);
		
		/**
		 * As the application is now running spring I have to create a user with the correct
		 * security privileges. This is called in the testListProduct test method.
		 */
		Authentication auth = new UsernamePasswordAuthenticationToken("tomhardy@gmail.com", "password");
		SecurityContext securityContext = SecurityContextHolder.getContext();
		securityContext.setAuthentication(auth);

	}	

	/**
	 * test method to check the the Array list being returned to the method is not empty
	 * and that the correct view is being called.
	 * It also is testing the saleOrder.getCustomerEmail Method
	 * @throws Exception
	 */
	@Test
	public void testListProduct() throws Exception{
		String view = tested.listProduct(model);
		assertThat(view, CoreMatchers.equalTo("ProductOrderForm"));
		assertThat(model.get("productList"), notNullValue());
		assertThat(tested.so.getCustomerEmail(), notNullValue());
		verify(ss).findAll();
	}
	
	/**
	 * This test is to verify that when the SaleOrderController calls the getBySKU function
	 * which i have declared in the Setup method that the correct view is returned
	 * and that the productSelected object is not null.
	 * @throws Exception
	 */
	@Test
	public void testSelectedSKU() throws Exception{
		String view = tested.selectedSKU(123, model);
		
		assertThat(view, CoreMatchers.equalTo("ProductOrderFormQuantity"));
		assertThat(model.get("productSelected"), notNullValue());
		
		verify(ss).getBySKU(123);
		
	}
	
	/**
	 * This is the first of three tests to check the Quantity method in the SaleOrderController.
	 * In the Setup Method i declared a mock sale order (so) and set the Product SKU to the mock Product SKU number above (123)
	 * In this test method i am sending back a quantity of 0, so i am checking that the first if statement, If(quantity == 0)
	 * the resulting should be, the ProductOrderFormQuantity is returned, with the ProductSelected Object and that
	 * an error message is also returned.  
	 * @throws Exception
	 */
	@Test
    public void testQuantity() throws Exception{
		String view = tested.Quantity(0, model);
        assertThat(view, CoreMatchers.equalTo("ProductOrderFormQuantity")); 
        assertThat(model.get("productSelected"), notNullValue());
        assertThat(model.get("Error_msg"), notNullValue()); 
        verify(ss).getBySKU(123);
    }
   
	/**
	 * This is the second check within the quantity method in the SaleOrderController. Here i am checking that quantity
	 * entered is not exceeding the quantity available for that product item. This time i mocked that the quantity of 
	 * product SKU 123 is 400, and that the customer requires a quantity of 401. So i am checking that the 
	 * ProductOrderFormQuantity view is being returned along with an error message and that the productSelected Object
	 * is not null. 
	 * @throws Exception
	 */
    @Test
    public void testQuantity1() throws Exception{
    	when(ss.getQuantityBySKU(123)).thenReturn(400);
        String view = tested.Quantity(401, model);
        assertThat(view, CoreMatchers.equalTo("ProductOrderFormQuantity"));
        assertThat(model.get("productSelected"), notNullValue());
        assertThat(model.get("Error_msg"), notNullValue()); 
        verify(ss).getQuantityBySKU(123);
    }
   
    /**
     * This is the final check of the quantity method within the SaleOrderController, Here i have mocked that the quantity
     * of the mock product SKU 123 is 12 and that the customer requires 9, so the Quantity check should pass and 
     * return the ProductOrderShippingDetails, and that the customer Object is not null. 
     * @throws Exception
     */
    @Test
    public void testQuantity2() throws Exception{
    	when(ss.getQuantityBySKU(123)).thenReturn(12);
        String view = tested.Quantity(9, model);
        assertThat(model.get("customer"), notNullValue());
        assertThat(view, CoreMatchers.equalTo("productOrderShippingDetails"));
        
        verify(ss).getQuantityBySKU(123);    
	}
}
