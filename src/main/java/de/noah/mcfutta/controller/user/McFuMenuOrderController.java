package de.noah.mcfutta.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import de.noah.mcfutta.collections.Repositories;
import de.noah.mcfutta.collections.order.Order;

@Controller
public class McFuMenuOrderController {

	@GetMapping("/order/menu/{id}")
	public String orderMenu(Model model, @PathVariable String id) {
		
		model.addAttribute("number_id", ++Order.counter);
		model.addAttribute("menu", Repositories.menus.findById(id).get());
		
		return "order_menu";
	}
}
