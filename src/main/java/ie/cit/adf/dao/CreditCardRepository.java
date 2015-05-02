package ie.cit.adf.dao;

import ie.cit.adf.domain.CreditCard;

public interface CreditCardRepository {

	CreditCard getbyEmailAddress(String email);

	void save(CreditCard creditCard);
	
}
