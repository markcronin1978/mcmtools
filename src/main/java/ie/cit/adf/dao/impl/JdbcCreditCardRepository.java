package ie.cit.adf.dao.impl;

import javax.sql.DataSource;

import ie.cit.adf.dao.CreditCardRepository;
import ie.cit.adf.dao.mapper.CreditCardMapper;
import ie.cit.adf.dao.mapper.CustomerMapper;
import ie.cit.adf.domain.CreditCard;
import ie.cit.adf.domain.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class JdbcCreditCardRepository implements CreditCardRepository {
	
	
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcCreditCardRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/**
	 * SQL Statement to return a credit card by email. 
	 */
	public CreditCard getbyEmailAddress(String email) {
		String sql = "SELECT * FROM creditcard WHERE email = ?";
		return jdbcTemplate.queryForObject(sql, new CreditCardMapper(), email);
	}
	
	/**
	 * When the credit card is save the following check is done. 
	 * Calls the searchByEmail method to check is a credit card for that customer already exists.
	 * If not it will add the credit card information. If a credit card already exists
	 * it will update the information stored with the current information.
	 */
	public void save(CreditCard creditCard) {
		if (searchByEmail(creditCard.getEmail()) == null) {
			add(creditCard);
		} else {
			update(creditCard);
		}
	}

	/**
	 * Check to see if a credit card for a customer already exists. 
	 * @param email
	 * @return null
	 */
	public CreditCard searchByEmail(String email) {
		try {
			String sql = "SELECT * FROM creditCard WHERE email = ?";
			return jdbcTemplate.queryForObject(sql, new CreditCardMapper(), email);
		} catch (DataAccessException e) {

		}
		return null;
	}	

	/**
	 * Insert Credit Card information.
	 * @param creditCard
	 */
	public void add(CreditCard creditCard) {
		jdbcTemplate  
				.update("INSERT INTO creditcard (id, name, number, email, expmonth, expyear, security, cardtype)"
						+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)", creditCard.getId(), 
						creditCard.getName(), creditCard.getNumber(), creditCard.getEmail(), 
						creditCard.getExpMonth(), creditCard.getExpYear(), creditCard.getSecurityCode(), creditCard.getCardType());
		

	}

	/**
	 * Update existing credit card information.
	 * @param creditCard
	 */
	private void update(CreditCard creditCard) {
		jdbcTemplate
				.update("UPDATE creditcard SET name = ?, number = ?, email = ?, expmonth = ?, "
						+ "expyear = ?, security = ?, cardtype = ?"
						+ " WHERE email = ?", creditCard.getName(), creditCard.getNumber(), creditCard.getEmail(), 
						creditCard.getExpMonth(), creditCard.getExpYear(), creditCard.getSecurityCode(), creditCard.getCardType(),creditCard.getEmail());
	}

}
