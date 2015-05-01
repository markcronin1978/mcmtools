package ie.cit.adf.service.IntegrationTest;

import ie.cit.adf.domain.Customer;
import ie.cit.adf.service.CustomerService;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
@Transactional
public class CustomerServiceIntegrationTest {
	
	@Autowired
	CustomerService tested;
	
	/**
	 * testing the save method for both the 
	 * save and Update Customer transactions
	 */
	@Test
	public void testSave(){
		Customer c = new Customer();
		c.setId("1L");
		c.setAddress1("The Street");
		c.setAddress2("The Neighbourhood");
		c.setAddress3("Cork");
		c.setFirstName("Tom");
		c.setLastName("Hardy");
		c.setEmail("tomhardy@gmail.com");
		c.setPassword("password");

		tested.save(c);
		
		Customer cFromDB = tested.getById(c.getId());
		Assert.assertThat(c.getFirstName(), CoreMatchers.equalTo(cFromDB.getFirstName()));	
		
		
		c.setId("1L");
		c.setAddress1("The Street");
		c.setAddress2("The Neighbourhood");
		c.setAddress3("Cork");
		c.setFirstName("Jim");
		c.setLastName("Hardy");
		c.setEmail("tomhardy@gmail.com");
		c.setPassword("password");
		
		tested.save(c);
		Customer cFromDB1 = tested.getById(c.getId());
		System.out.println(cFromDB1.getFirstName());
		Assert.assertThat(c.getFirstName(), CoreMatchers.equalTo(cFromDB1.getFirstName())); 
		
	}
	
	/**
	 * Testing the findAll method for Customers.
	 */
	@Test
	public void testFindAll(){
		tested.findAll();
		Assert.assertThat(tested.findAll().size(), CoreMatchers.notNullValue());
	}

}
