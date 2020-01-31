package de.noah.mcfutta.collections.order;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import de.noah.mcfutta.collections.menus.FoodTypeCollection;

@Document(collection = "orders")
public class Order {
	
	public static int counter = 0;

	@Id
	private String id;
	
	private int number;
	private int status;
	private float price = 404; //404 - real price not found :-)
	private String menuID;
	
	private FoodTypeCollection food; //reused
	
	public Order() {
		id = UUID.randomUUID().toString();
	}
	
	

	public String getId() {
		return id;
	}



	public void setId(String uuid) {
		this.id = uuid;
	}



	public int getNumber() {
		return number;
	}



	public void setNumber(int number) {
		this.number = number;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}



	public String getMenuID() {
		return menuID;
	}



	public void setMenuID(String menuID) {
		this.menuID = menuID;
	}



	public FoodTypeCollection getFood() {
		return food;
	}



	public void setFood(FoodTypeCollection food) {
		this.food = food;
	}



	@Override
	public String toString() {
		return "Order [uuid=" + id + ", id=" + number + ", status=" + status + ", menuID=" + menuID + ", food=" + food + "]";
	}



	public double getPrice() {
		double price = 0;
		for (int i = 0; i < food.getFood().length; i++) {
			price += food.getFood()[i].getPrice() * 100d;
		}
		return price / 100d;
	}
	
	
}
