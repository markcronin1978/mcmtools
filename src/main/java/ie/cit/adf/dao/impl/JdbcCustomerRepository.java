package ie.cit.adf.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ie.cit.adf.dao.CustomerRepository;
import ie.cit.adf.dao.mapper.CustomerMapper;
import ie.cit.adf.dao.mapper.ProductMapper;
import ie.cit.adf.domain.Customer;
import ie.cit.adf.domain.Product;

@Repository
public class JdbcCustomerRepository implements CustomerRepository {

	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcCustomerRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//list all customers.
	public List<Customer> findAll() {
		System.out.println("JDBC FIle");
		String sql = "SELECT * FROM customer";
		return jdbcTemplate.query(sql, new CustomerMapper());
	}

	//checks to see if new or update product action is required
	public void save(Customer customer) {
		if (searchByEmail(customer.getEmail()) == null) {
			System.out.println("JDBC FIle");
			add(customer);
		} else {
			update(customer);
		}
	}
	
	//searches database to check for existing Email address, if not present catches SQL Exception and returns null
	public Customer searchByEmail(String email) {
		try {
			String sql = "SELECT * FROM customer WHERE email = ?";
			return jdbcTemplate.queryForObject(sql, new CustomerMapper(), email);
		} catch (DataAccessException e) {

		}
		return null;
	}
	
	//insert new Customer information
	public void add(Customer customer) {
		jdbcTemplate  
				.update("INSERT INTO customer (id, firstname, lastname, address1, address2, address3, email, password)"
						+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)", customer.getId(), 
						customer.getFirstName(), customer.getLastName(), customer.getAddress1(), 
						customer.getAddress2(), customer.getAddress3(), customer.getEmail(), customer.getPassword());

	}

	//update new product information
	private void update(Customer customer) {
		jdbcTemplate
				.update("UPDATE customer SET id= ?, firstname = ?, lastname = ?, address1 = ?, address2 = ?"
						+ "address3 = ?, email = ?, password = ?"
						+ " WHERE email = ?", customer.getId(), customer.getFirstName(), customer.getLastName(),
						customer.getAddress1(), customer.getAddress2(), customer.getAddress3(), customer.getPassword(), 
						customer.getEmail());
	}

	//return customer by email address
	public Customer getByEmailAddress(String email) {
		String sql = "SELECT * FROM customer WHERE email = ?";
		return jdbcTemplate.queryForObject(sql, new CustomerMapper(), email);
	}

	public Customer getById(String id) {
		String sql = "SELECT * FROM customer WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new CustomerMapper(), id);
	}

	public List<Customer> getByCity(String city) {
		String sql = "SELECT * FROM customer WHERE address3 = ?";
		return jdbcTemplate.query(sql, new CustomerMapper(), city);
	}
	
}
