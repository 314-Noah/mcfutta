package de.noah.mcfutta.controller.list;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.noah.mcfutta.collections.Repositories;
import de.noah.mcfutta.collections.order.Order;

@RestController
public class MFOLUpdateController {

	@RequestMapping(value = { "/orders/increment", "/" }, method = RequestMethod.POST)
    public void create(@RequestBody String msg) {
		Order order = Repositories.orders.findById(msg.substring(0, msg.length() - 1)).get();
		order.setStatus(order.getStatus() + 1 > 2 ? 3 : order.getStatus() + 1 );
		Repositories.orders.save(order);
		System.out.println("Updatet order");
		//Repositories.orders.
	}
	
}
