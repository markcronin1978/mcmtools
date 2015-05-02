package ie.cit.adf.domain;

import java.util.UUID;



public class Product {
	
	private String id;
	private int SKU;
	private String name;
	private String description;
	private double pricePerUnit;
	private int stockLevel;
	
	public Product(){
		this.id = UUID.randomUUID().toString();
	}
	
	public Product(String id, int sKU, String name, String description, double pricePerUnit,
			int stockLevel) {
		super();
		this.id = UUID.randomUUID().toString();
		SKU = sKU;
		this.name = name;
		this.description = description;
		this.pricePerUnit = pricePerUnit;
		this.stockLevel = stockLevel;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public int getSKU() {
		return SKU;
	}


	public void setSKU(int sKU) {
		SKU = sKU;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getPricePerUnit() {
		return pricePerUnit;
	}


	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}


	public int getStockLevel() {
		return stockLevel;
	}


	public void setStockLevel(int stockLevel) {
		this.stockLevel = stockLevel;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", SKU=" + SKU + ", description="
				+ description + ", pricePerUnit=" + pricePerUnit
				+ ", stockLevel=" + stockLevel + "]";
	}
	
	

}
