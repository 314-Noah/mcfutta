package de.noah.mcfutta.collections.old_shop;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "shoppingcart")
public class Einkauf {

	@Id
	private long id;
	
	private String productName;
	private int amount;
	
	public Einkauf() {
		// TODO Auto-generated constructor stub
	}
	
	public Einkauf(String productName, int amount) {
		this.productName = productName;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Einkauf[" + amount + " x " + productName + "] ";
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
}
