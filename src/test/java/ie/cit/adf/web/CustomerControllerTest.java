package ie.cit.adf.web;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.hamcrest.CoreMatchers.notNullValue;


import ie.cit.adf.domain.Customer;
import ie.cit.adf.service.CustomerService;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Description;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.springframework.ui.ExtendedModelMap;

public class CustomerControllerTest {
	
	private CustomerService customerService;
	private CustomerController tested;
	private ExtendedModelMap model;
	
	@Before
	public void setup(){
		customerService = mock(CustomerService.class);
		tested = new CustomerController(customerService);
		model = new ExtendedModelMap();
		
		/**
		 * here i am create a new customer to use in the 
		 * testing of the save customer function
		 */
		Customer customer = new Customer();
		customer.setId("L1");
		customer.setAddress1("The Street");
		customer.setAddress2("The Neighbourhood");
		customer.setAddress3("Cork");
		customer.setFirstName("Tom");
		customer.setLastName("Hardy");
		customer.setEmail("tomhardy@yahoo.com");
		customer.setPassword("hello123");
		
		tested.addCustomer(customer);
		
	}	
	
	/**
	 * Test the listCustomer method in the Customer Controller
	 * @throws Exception
	 */
	@Test
	public void testListCustomers() throws Exception {
		String view = tested.listCustomers(model);
		assertThat(view, CoreMatchers.equalTo("customerList"));
		assertThat(model.get("customers"), notNullValue());
		verify(customerService).findAll();
		
	}
	
	/**
	 * test the formCustomer method returns to correct view 
	 * @throws Exception
	 */
	@Test
	public void testFormCustomer() throws Exception {
		String view = tested.formCustomer(model);
		assertThat(view, CoreMatchers.equalTo("customerForm"));
		/*assertThat(model.get("customer"), notNullValue());
		System.out.println(model.get("customer").getClass().getName().toString());*/
		//verify(tested).formCustomer(model);
		
	}
	
	/** 
	 * test the addCustomer function
	 */
	@Test
	public void testAddCustomer(){
		
		Mockito.verify(customerService).save(Mockito.argThat(new ArgumentMatcher<Customer>(){
			@Override
			public boolean matches(Object argument){
				return ((Customer) argument).getFirstName().equals("Tom");
			}
		}));
		//verify(cs).save(customer);
		//cs.save(customer);
		//Mockito.verify(cs).save(customer);
		//Customer c = cs.getByEmailAddress("tomhardy@yahoo.com");
		//c.getFirstName().toString();
		//System.out.println(customer2.getFirstName().toString());
		//assertTrue(c.getFirstName().equals("Tom"));
		
		
		
	}
}
