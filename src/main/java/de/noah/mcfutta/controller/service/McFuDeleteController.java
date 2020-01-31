package de.noah.mcfutta.controller.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import de.noah.mcfutta.collections.Repositories;

@Controller
public class McFuDeleteController {

	@GetMapping("/sub/menu/delete")
	public String delete(Model model) {
		
		model.addAttribute("title", "McFutta - MenuDestroyer");
		model.addAttribute("menus", Repositories.menus.findAll());
		
		return "delete_menu";
	}
	
	@GetMapping("/ops/menu/delete/{id}")
	public String deleteOperation(Model model, @PathVariable String id) {
		
		Repositories.menus.deleteById(id);
		
		return "redirect:/";
	}
	
	@GetMapping("/ops/food/delete/{id}")
	public String deleteFoodOperation(Model model, @PathVariable String id) {
		
		Repositories.food.deleteById(id);
		
		return "redirect:/food";
	}
	
	@GetMapping("/info")
	public String info(Model model) {
		return "info";
	}
	
}
