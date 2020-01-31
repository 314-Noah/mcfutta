package de.noah.mcfutta.collections.menus;

import java.util.Arrays;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import de.noah.mcfutta.collections.Repositories;

@Document(collection = "menus")
public class Menu {

	@Id
	private String id;
	
	private String name;
	private FoodTypeCollection[] collections;
	
	public Menu() {
		id = UUID.randomUUID().toString();
	}

	public Menu(String name, FoodTypeCollection... collections) {
		this.setName(name);
		this.setCollections(collections);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = Repositories.revert(name);
	}

	public FoodTypeCollection[] getCollections() {
		return collections;
	}

	public void setCollections(FoodTypeCollection[] collections) {
		this.collections = collections;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Menu [name=" + name + ", collections=" + Arrays.toString(collections) + "]";
	}
	
	
	
}
