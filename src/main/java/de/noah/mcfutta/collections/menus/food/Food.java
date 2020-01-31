package de.noah.mcfutta.collections.menus.food;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import de.noah.mcfutta.collections.Repositories;

@Document(collection = "food")
public class Food {

	@Id
	private String id;
	
	private String name;
	private double price;
	private String color;

	public Food() {
		id = UUID.randomUUID().toString();
	}
	
	public Food(String name, double price, String color) {
		this();
		this.name = Repositories.revert(name);
		setPrice(price);
		this.color = color;
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
		this.name = Repositories.revert(name);
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Food [name=" + name + ", price=" + price + ", color=" + color + "]";
	}
	
	
	
}
