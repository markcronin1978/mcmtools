package ie.cit.adf.domin;

import java.util.UUID;

public class saleOrders {

	private String id;
	private int customerId;
	private int productSKU;
	private int quantity;
	private double cost;	
	
	public saleOrders(String id, int customerId, int productSKU, int quantity) {
		super();
		this.id = UUID.randomUUID().toString();
		this.customerId = customerId;
		this.productSKU = productSKU;
		this.quantity = quantity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
		return "saleOrders [id=" + id + ", customerId=" + customerId
				+ ", productSKU=" + productSKU + ", quantity=" + quantity
				+ ", cost=" + cost + "]";
	}

	
	
	
	
}
