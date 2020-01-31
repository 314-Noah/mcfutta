package de.noah.mcfutta.controller.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import de.noah.mcfutta.collections.Repositories;
import de.noah.mcfutta.collections.menus.food.Food;

@Controller
public class McFuMenuController {

	@GetMapping("/menu")
	public String menu(Model model) {
		
		model.addAttribute("title", "McFutta - MenuCreator");
		model.addAttribute("foods", Repositories.food.findAll());
		
		return "menu";
	}
	
	/*
	
	@GetMapping("/menu")
	public String menu(@RequestBody String str, Model model) {
		
		model.addAttribute("title", "McFutta - MenuCreator");
		model.addAttribute("foods", Repositories.food.findAll());
		
		System.out.println("Erhalten: " + str);
		
		return "menu";
	}*/
//	
	
}
