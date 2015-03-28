package ie.cit.adf.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import ie.cit.adf.domain.Customer;

import org.springframework.jdbc.core.RowMapper;

public class CustomerMapper implements RowMapper<Customer> {

	/**
	 * here i am using RowMapper the retrieve and add customer information to the database
	 */
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer c = new Customer();
		c.setId(rs.getString("id"));
		c.setFirstName(rs.getString("firstName"));
		c.setLastName(rs.getString("lastName"));		
		c.setAddress1(rs.getString("address1"));
		c.setAddress2(rs.getString("address2"));
		c.setAddress3(rs.getString("address3"));
		c.setEmail(rs.getString("email"));
		c.setPassword(rs.getString("password"));
		
		return c;
	}

}
