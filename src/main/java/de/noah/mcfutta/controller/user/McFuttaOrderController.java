package de.noah.mcfutta.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import de.noah.mcfutta.collections.Repositories;

@Controller
public class McFuttaOrderController {


	
	@GetMapping("/")
	public String main(Model model) {
		
		model.addAttribute("title", "McFutta");
		model.addAttribute("menus", Repositories.menus.findAll());
		
		return "main";
	}
	
	@GetMapping("/error")
	public String error(Model model) {
		return "error";
	}
	
}
