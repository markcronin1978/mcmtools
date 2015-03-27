package ie.cit.adf.web;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import ie.cit.adf.domain.Product;
import ie.cit.adf.service.SaleOrderService;

import org.mockito.ArgumentMatcher;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.springframework.ui.ExtendedModelMap;

import static org.mockito.Mockito.*;

public class SaleOrderControllerTest {
	
	private SaleOrderService ss;
	private SaleOrderController tested;
	private ExtendedModelMap model;
	
	
	@Before
	public void setup(){
		ss = mock(SaleOrderService.class);
		tested = new SaleOrderController(ss);
		model = new ExtendedModelMap();
		
	}	

	//test method that returns a list of available products.
	@Test
	public void testListProduct() {
		String view = tested.listProduct(model);
		assertThat(view, CoreMatchers.equalTo("ProductOrderForm"));
		assertThat(model.get("productList"), notNullValue());
		verify(ss).findAll();
	}
	
	@Test
	public void testSelectedSKU() throws Exception{
		String view = tested.selectedSKU(0, model);
		assertThat(view, CoreMatchers.equalTo("ProductOrderFormQuantity"));
		assertThat(model.get(0), nullValue());
		verify(ss).getBySKU(0);
		
	}
	
	//test the correct view is being returned and i have passed a quantity value of 0
	@Test
	public void testQuantity() throws Exception{
		int quantity = 0;
		/**int quantity = 0;
		String view = tested.Quantity(quantity, model);
		if(quantity==0){
			assertThat(view, CoreMatchers.equalTo("ProductOrderFormQuantity"));
			assertThat(model.get(1000), nullValue());	
		}
		else if(quantity==10000){
			assertThat(view, CoreMatchers.equalTo("ProductOrderFormQuantity"));
			assertThat(model.get(1000), nullValue());
		}
		else if(quantity==5){
			assertThat(view, CoreMatchers.equalTo("ProductOrderFormQuantity"));
			assertThat(model.get(1000), nullValue());
		}**/
		String view = tested.Quantity(quantity , model);
		when(ss.getQuantityBySKU(123)).thenReturn(0);
		when(ss.getQuantityBySKU(321)).thenReturn(10000);
		when(ss.getQuantityBySKU(333)).thenReturn(55);
		//assertThat(view, CoreMatchers.equalTo("ProductOrderFormQuantity"));
		if(ss.getQuantityBySKU(123)==0){
			assertThat(view, CoreMatchers.equalTo("ProductOrderFormQuantity"));			
		}
		if(ss.getQuantityBySKU(321)==500){
			assertThat(view, CoreMatchers.equalTo("ProductOrderFormQuantity"));			
		}
		else{
			assertThat(view, CoreMatchers.equalTo("productOrderShippingDetails"));	
		}
		
	}
	

}
