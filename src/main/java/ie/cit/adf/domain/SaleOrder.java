package ie.cit.adf.domain;

import java.util.UUID;

public class SaleOrder {

	private String id;
	private String customerEmail;
	private int productSKU;
	private int quantity;
	private double cost;	
	
	public SaleOrder(){
		this.id = UUID.randomUUID().toString();
	}
	
	public SaleOrder(String id, String customerEmail, int productSKU, int quantity) {
		super();
		this.id = UUID.randomUUID().toString();
		this.customerEmail = customerEmail;
		this.productSKU = productSKU;
		this.quantity = quantity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public int getProductSKU() {
		return productSKU;
	}

	public void setProductSKU(int productSKU) {
		this.productSKU = productSKU;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "SaleOrder [id=" + id + ", customerEmail=" + customerEmail
				+ ", productSKU=" + productSKU + ", quantity=" + quantity
				+ ", cost=" + cost + "]";
	}

	
}
