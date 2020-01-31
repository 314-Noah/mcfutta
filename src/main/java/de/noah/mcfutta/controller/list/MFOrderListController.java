package de.noah.mcfutta.controller.list;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import de.noah.mcfutta.collections.Repositories;

@Controller
public class MFOrderListController {


	@GetMapping("/orders")
	public String orders(Model model) {
		
		model.addAttribute("orders", Repositories.orders.findByStatusNot(3));
		
		return "orders";
	}
	
	@GetMapping("/orders/all")
	public String ordersAll(Model model) {
		
		model.addAttribute("orders", Repositories.orders.findAll());
		
		return "orders";
	}
	
	
}
