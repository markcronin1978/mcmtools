package ie.cit.adf.domain;

import java.util.UUID;

public class Customer {

	private String id;
	private int firstName;
	private int lastName;
	private int address1;
	private int address2;
	private int address3;
	private String email;
	private String password;
	
	
	public Customer(String id, int firstName, int lastName, int address1,
			int address2, int address3, String email, String password) {
		super();
		this.id = UUID.randomUUID().toString();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.email = email;
		this.password = password;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public int getFirstName() {
		return firstName;
	}


	public void setFirstName(int firstName) {
		this.firstName = firstName;
	}


	public int getLastName() {
		return lastName;
	}


	public void setLastName(int lastName) {
		this.lastName = lastName;
	}


	public int getAddress1() {
		return address1;
	}


	public void setAddress1(int address1) {
		this.address1 = address1;
	}


	public int getAddress2() {
		return address2;
	}


	public void setAddress2(int address2) {
		this.address2 = address2;
	}


	public int getAddress3() {
		return address3;
	}


	public void setAddress3(int address3) {
		this.address3 = address3;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", address1=" + address1
				+ ", address2=" + address2 + ", address3=" + address3
				+ ", email=" + email + ", password=" + password + "]";
	}
	
	
	

}
