package ie.cit.adf.domain;

import java.math.BigDecimal;
import java.util.UUID;



public class CreditCard {
	private String id;
	private String name;
	private BigDecimal number; 
	private String email;
	private int expMonth;
	private int expYear;
	private int securityCode;
	private String cardType;

	public CreditCard(){
		this.id = UUID.randomUUID().toString();
	}


	public CreditCard(String id, int creditCardID,String name, String email, BigDecimal number,int expMonth,int expYear, int securityCode,String cardType){
	
		this.id= id;
	    this.name=name;
	    this.email = email;
	    this.number=number;
	    this.expMonth=expMonth;
	    this.expYear=expYear;
	    this.securityCode=securityCode;
	   this.cardType=cardType;        
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public BigDecimal getNumber() {
		return number;
	}


	public void setNumber(BigDecimal number) {
		this.number = number;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getExpMonth() {
		return expMonth;
	}


	public void setExpMonth(int expMonth) {
		this.expMonth = expMonth;
	}


	public int getExpYear() {
		return expYear;
	}


	public void setExpYear(int expYear) {
		this.expYear = expYear;
	}


	public int getSecurityCode() {
		return securityCode;
	}


	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}


	public String getCardType() {
		return cardType;
	}


	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	
}
	