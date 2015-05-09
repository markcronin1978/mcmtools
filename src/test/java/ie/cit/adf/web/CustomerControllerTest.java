package ie.cit.adf.web;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.hamcrest.CoreMatchers.notNullValue;








import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import ie.cit.adf.domain.Customer;
import ie.cit.adf.service.CustomerService;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Description;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.validation.BindingResult;

public class CustomerControllerTest {
	
	private CustomerService customerService;
	private CustomerController tested;
	private ExtendedModelMap model;
	private static Validator validator;
	private Customer customer;
	private Customer customer1;
	
	@Before
	public void setup(){
		customerService = mock(CustomerService.class);
		tested = new CustomerController(customerService);
		model = new ExtendedModelMap();
		BindingResult result = mock(BindingResult.class);		

		
		/**
		 * here i am create a new customer to use in the 
		 * testing of the save customer function
		 */
		customer = new Customer();
		customer.setId("L1");
		customer.setAddress1("The Street");
		customer.setAddress2("The Neighbourhood");
		customer.setAddress3("Cork");
		customer.setFirstName("Tom");
		customer.setLastName("Hardy");
		customer.setEmail("tomhardy@yahoo.com");
		customer.setPassword("password");
		
		customer1 = new Customer();
		customer1.setId("L1");
		customer1.setAddress1("");
		customer1.setAddress2("The Neighbourhood");
		customer1.setAddress3("Cork");
		customer1.setFirstName("");
		customer1.setLastName("Hardy");
		customer1.setEmail("tomhardy@yahoo.com");
		customer1.setPassword("password");
		
		/**
		 * I am declaring that when the addCustomer function is called, the mock customer will be save. 
		 */
		tested.addCustomer(customer, result, model);	
		
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
	}
	
	/** 
	 * test the addCustomer function
	 * test the javax validator
	 */
	@Test
	public void testAddCustomer(){

		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();	
		
		Set<ConstraintViolation<Customer>> constraintViolations = validator.validateValue(Customer.class, "firstName", "Tom");
		assertEquals(0, constraintViolations.size());

		
		Mockito.verify(customerService).save(Mockito.argThat(new ArgumentMatcher<Customer>(){
			@Override
			public boolean matches(Object argument){
				return ((Customer) argument).getFirstName().equals("Tom");
			}
		}));
	}

}
