package ie.cit.adf.service.IntegrationTest;


import ie.cit.adf.domain.Product;
import ie.cit.adf.service.ProductService;

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
public class ProductServiceIntegrationTest {
	
	@Autowired
	ProductService tested;
	
	/**
	 * Method is used to test the FindAll method.
	 */
	@Test
	public void testFindAll(){
		tested.findAll();
		Assert.assertThat(tested.findAll().size(), CoreMatchers.notNullValue());
	}
	 
	/**
	 * Testing the Save method for both
	 * the Save and Update Transaction.
	 */
	@Test
	public void testSave(){
		Product p = new Product();
		p.setId("1L");
		p.setSKU(123);
		p.setName("Trition");
		p.setDescription("Air Saw");
		p.setPricePerUnit(25.00);
		p.setStockLevel(25);

		tested.save(p);
		Product pFromDB = tested.getBySKU(123);
		Assert.assertThat(p.getName(), CoreMatchers.equalTo(pFromDB.getName()));
		
		p.setId("1L");
		p.setSKU(123);
		p.setName("Trition");
		p.setDescription("Air Saw");
		p.setPricePerUnit(35.00);
		p.setStockLevel(25);
		
		tested.save(p);
		Product pFromDB1 = tested.getBySKU(123);
		Assert.assertThat(p.getPricePerUnit(), CoreMatchers.equalTo(pFromDB1.getPricePerUnit()));
		
	}

}
