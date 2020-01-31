package de.noah.mcfutta.controller.user;

import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.noah.mcfutta.collections.Repositories;
import de.noah.mcfutta.collections.menus.FoodTypeCollection;
import de.noah.mcfutta.collections.menus.food.Food;
import de.noah.mcfutta.collections.order.Order;

@RestController
public class MFMORequestController {

	@RequestMapping(value = { "/create-order", "/" }, method = RequestMethod.POST)
    public void handleRequest(@RequestBody String msg) {
		System.out.println("Datensatz erhalten: " + msg);
		msg = msg.substring(0, msg.length() - 1);
		
		String[] part = msg.split("-%23-");
		
		for (int i = 0; i < part.length; i++) {
			System.out.println(part[i]);
		}
		
		Order order = new Order();
		order.setNumber(Integer.parseInt(part[0]));
		order.setMenuID(part[1]);
		order.setStatus(0);
		
		Food[] food = new Food[part.length-2];
		for (int i = 2; i < part.length; i++) {
			System.out.println(part[i]);
			try {
				food[i-2] = Repositories.food.findById(part[i]).get();
			} catch(NoSuchElementException e) {
				food[i-2] = new Food("Gelöscht", 0.0, "rgb(200, 0, 1)");
			}
		}
		order.setFood(new FoodTypeCollection(Repositories.menus.findById(part[1]).get().getName(), food));
		
		System.out.println(order);
		
		Repositories.orders.save(order);
	}
	
}
