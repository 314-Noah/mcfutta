package de.noah.mcfutta.controller.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.noah.mcfutta.collections.Repositories;
import de.noah.mcfutta.collections.menus.FoodTypeCollection;
import de.noah.mcfutta.collections.menus.Menu;
import de.noah.mcfutta.collections.menus.food.Food;
import de.noah.mcfutta.util.Util;

@RestController
public class McFuMenuCreateController {


	@RequestMapping(value = { "/create-menu", "/" }, method = RequestMethod.POST)
    public void create(@RequestBody String msg) {
		System.out.println("Datensatz erhalten: " + msg);
		
		msg = msg.substring(4);
		msg = msg.replace("+", " ");
		msg = msg.replaceAll("%3C", "<");
		msg = msg.replaceAll("%3F", "?");
		
		msg = Repositories.revert(msg);

		System.out.println("Datensatz bearbeitet: " + msg);
		
		String[] block = msg.split("-%23-");
		
		Menu menu = new Menu();
		List<FoodTypeCollection> ftcs = new ArrayList<>();
		
		for (int i = 0; i < block.length - 1; i++) {
			String[] part = block[i].split("%23-%23");
			Food[] feed = new Food[part.length - 1];
			
			for (int j = 1; j < part.length; j++) {
				feed[j-1] = Repositories.food.getByName(part[j]);
			}
			ftcs.add(new FoodTypeCollection(part[0], feed));
		}
		
		menu.setName(block[block.length-1]);
		menu.setCollections(Util.asArray(ftcs));
		
		Repositories.menus.save(menu);
    }
	
}
//TODO alle +'se durch Leerzeichen ersetzen, str= rausfiltern und ? richtig darstellen
