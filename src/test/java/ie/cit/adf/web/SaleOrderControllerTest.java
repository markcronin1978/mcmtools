package ie.cit.adf.web;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import ie.cit.adf.domain.Product;
import ie.cit.adf.service.SaleOrderService;


import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;


public class SaleOrderControllerTest {
	
	private SaleOrderService ss;
	private SaleOrderController tested;
	private ExtendedModelMap model;
	
	
	@Before
	public void setup(){
		ss = mock(SaleOrderService.class);
		tested = new SaleOrderController(ss);
		model = new ExtendedModelMap();
				
		Product p = new Product();
		p.setId("1L");
		p.setSKU(123);
		p.setName("Trition");
		p.setDescription("Air Saw");
		p.setPricePerUnit(25.00);
		p.setStockLevel(25);
		
		List<Product> pList = new ArrayList<Product>();
		pList.add(p);
		
		when(ss.findAll()).thenReturn(pList);
		when(ss.getBySKU(123)).thenReturn(p);
		when(ss.getQuantityBySKU(123)).thenReturn(25);
			
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
		String view = tested.selectedSKU(123, model);
		assertThat(view, CoreMatchers.equalTo("ProductOrderFormQuantity"));
		assertThat(model.get("productSelected"), notNullValue());
		verify(ss).getBySKU(123);
		
	}
	
	//test the correct view is being returned and i have passed a quantity value of 0
	@Test
	public void testQuantity() throws Exception{
		//int quantity = 0;
		String view = tested.Quantity(25, model);
		assertThat(view, CoreMatchers.equalTo("ProductOrderFormQuantity"));
		//assertThat(model.get("productSelected"), notNullValue());
		verify(ss).getQuantityBySKU(0);

		/**String view = tested.Quantity(quantity , model);
		when(ss.getQuantityBySKU(123)).thenReturn(0);
		//when(ss.getQuantityBySKU(321)).thenReturn(10000);
		//when(ss.getQuantityBySKU(333)).thenReturn(55);
		//assertThat(view, CoreMatchers.equalTo("ProductOrderFormQuantity"));
		if(ss.getQuantityBySKU(123)==0){
			assertThat(view, CoreMatchers.equalTo("ProductOrderFormQuantity"));			
		}
		else if(ss.getQuantityBySKU(321)==500){
			assertThat(view, CoreMatchers.equalTo("ProductOrderFormQuantity"));			
		}
		else{
			assertThat(view, CoreMatchers.equalTo("productOrderShippingDetails"));	
		} **/
		
		
		
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
		
	}

	

}
