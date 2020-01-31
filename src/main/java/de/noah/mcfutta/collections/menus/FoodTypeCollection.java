package de.noah.mcfutta.collections.menus;

import java.util.Arrays;

import de.noah.mcfutta.collections.Repositories;
import de.noah.mcfutta.collections.menus.food.Food;

public class FoodTypeCollection {

	private String question;
	private Food[] food;
	
	
	public FoodTypeCollection(String question, Food... food) {
		this.question = question;
		this.food = food;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = Repositories.revert(question);
	}


	public Food[] getFood() {
		return food;
	}


	public void setFood(Food[] food) {
		this.food = food;
	}


	@Override
	public String toString() {
		return "FoodTypeCollection [question=" + question + ", food={\r\n		" + Arrays.toString(food) + "	\r\n}]";
	}
	
	
	
}
