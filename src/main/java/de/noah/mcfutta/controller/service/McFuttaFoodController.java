package de.noah.mcfutta.controller.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import de.noah.mcfutta.collections.Repositories;
import de.noah.mcfutta.collections.menus.food.Food;

@Controller
public class McFuttaFoodController {


	@GetMapping("/food")
	public String main(Model model) {
		
		model.addAttribute("title", "Service - FoodCreator");
		model.addAttribute("foods", Repositories.food.findAll());
		model.addAttribute("food_", new Food());
		
		return "food";
	}
	
	@PostMapping("/food")
	public String mainPost(@ModelAttribute("food_") Food food, Model model) {

		model.addAttribute("food_", new Food());
		
		Repositories.food.save(food);
		
		return "redirect:/food";
	}
	
}
