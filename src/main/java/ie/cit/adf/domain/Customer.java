package ie.cit.adf.domain;

import java.util.UUID;



public class Customer {

	private String id;
	private String firstName;
	private String lastName;
	private String address1;
	private String address2;
	private String address3;
	private String email;
	private String password;
	
	public Customer(){
		this.id = UUID.randomUUID().toString();
	}

	public Customer(String id, String firstName, String lastName,
			String address1, String address2, String address3, String email, String password) {
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password =password;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", address1=" + address1
				+ ", address2=" + address2 + ", address3=" + address3
				+ ", email=" + email + ", password=" + password + "]";
	}

}
