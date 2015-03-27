package ie.cit.adf.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import ie.cit.adf.dao.CustomerRepository;
import ie.cit.adf.domain.Customer;
import ie.cit.adf.service.CustomerService;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;

public class CustomerServiceImplTest {

	private CustomerService tested;
	private CustomerRepository customerRepository;

	
	@Before
	public void setup(){
		customerRepository = mock(CustomerRepository.class);
		tested = new CustomerServiceImpl(customerRepository);
		
		Customer c = new Customer();
		c.setId("1L");
		c.setAddress1("The Street");
		c.setAddress2("The Neighbourhood");
		c.setAddress3("Cork");
		c.setFirstName("Tom");
		c.setLastName("Hardy");
		c.setEmail("tomhardy@gmail.com");
		c.setPassword("password");
		
		/**what i am basically doing here is that when the customerRepository.getById 
		 * method is called then return the new customer i checked for testing processes**/
		when(customerRepository.getById("1L")).thenReturn(c);
		
		/**To verify that the customerRepository.findAll method is working,
		 * I have added the above customer to an arraylist**/
		List<Customer> clist = new ArrayList<Customer>();
		clist.add(c);
		
		/**When the customerRepository.findAll method is called it is expected a list
		 * in return, when the tester method findAll is called it will receive a list
		 * with the above customer in it!!**/
		when(customerRepository.findAll()).thenReturn(clist);
		
		/**I have put this into the setup method so that the customer will be saved when
		 * the testing begins. This will be used to verify that the customerRepository.save
		 * method is working**/
		tested.save(c);
		
	}
	
	@Test
	public void testGetById(){
		String firstName = tested.getById("1L").getFirstName();
		String secondName = tested.getById("1L").getLastName();
		assertTrue(firstName.equals("Tom") && secondName.equals("Hardy"));
		
	}
	@Test
	public void testListCustomers(){
		assertEquals(1, tested.findAll().size());		
	}
	
	@Test
	public void testSave(){			
		Mockito.verify(customerRepository).save(Mockito.argThat(new ArgumentMatcher<Customer>(){
			@Override
			public boolean matches(Object argument){
				return ((Customer) argument).getFirstName().equals("Tom");
			}
		}));
	}
	
	/**
	@Before
	public void setup() {
		customerRepository = mock(CustomerRepository.class);


		
		when(customerRepository.getById(1)).thenReturn(c);
		
		//List<Customer> clist = new ArrayList<Customer>();
		//clist.add(c);
		//when(customerRepository.getByCity("Cork")).thenReturn(clist);
		
		customerService = new CustomerServiceImpl(customerRepository);
	}
	
	@Test
	public void testGetCorkCustomers() {
		assertEquals(1, customerService.findAll().size());
	}

	@Test
	public void testGetById() {
		String firstName = customerService.getCustomer(1).getFirstName();
		String secondName = customerService.getCustomer(1).getSecondName();
		assertTrue(firstName.equals("Tom") && secondName.equals("Hardy"));
	}**/

}
