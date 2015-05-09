package ie.cit.adf.dao;

import ie.cit.adf.domain.CreditCard;

public interface CreditCardRepository {

	/**
	 * return credit card information for a specific customer.
	 * @param email
	 * @return
	 */
	CreditCard getbyEmailAddress(String email);
	
	/**
	 * save credit card information for a specific user
	 * @param creditCard
	 */
	void save(CreditCard creditCard);
	
}
