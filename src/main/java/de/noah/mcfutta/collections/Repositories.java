package de.noah.mcfutta.collections;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import de.noah.mcfutta.collections.menus.Menu;
import de.noah.mcfutta.collections.menus.MenuRepository;
import de.noah.mcfutta.collections.menus.food.Food;
import de.noah.mcfutta.collections.menus.food.FoodRepository;
import de.noah.mcfutta.collections.order.Order;
import de.noah.mcfutta.collections.order.OrderRepository;

@RestController
public class Repositories {

	public static OrderRepository orders;
	public static MenuRepository menus;
	public static FoodRepository food;

	@Bean
	CommandLineRunner initOrderDB(OrderRepository repo) {
		return args -> {
			
			orders = repo;
			
			List<Order> list = orders.findByStatusNot(3);
			
			for (int i = 0; i < list.size(); i++) {
				list.get(i).setStatus(3);
			}
			orders.saveAll(list);
			
		};
	}
	
	@Bean
	CommandLineRunner initFoodDB(FoodRepository repo) {
		
		food = repo;
		
		return args -> {
			
			if(repo.count() == 0) {
				repo.save(new Food("Pommes", 1.00, "#DDD000"));
				
				repo.save(new Food("Burger", 1.00, "#AA6600"));
				repo.save(new Food("Veggie_Burger", 1.00, "#AA6600"));
	
				repo.save(new Food("Greek_Salad", 1.20, "#00EE00"));
				repo.save(new Food("Salad", 1.80, "#00EE00"));
			}
			
			System.out.println("Essen:");
			List<Food> list = repo.findAll();
			for (int i = 0; i < list.size(); i++) {
				System.out.println("	-" + list.get(i));
			}
			System.out.println();
			
		};
	}
	
	@Bean
	CommandLineRunner initMenuDB(MenuRepository repo) {
		
		menus = repo;
		
		return args -> {
			
			if(repo.count() == 0) {
				//repo.save(new Menu("FlappyMeal", new FoodTypeCollection("Hunger?", "")));
				//Zu komplexes UUID System um Zahlen zu raten
			}
			
			System.out.println("Menus:");
			List<Menu> list = repo.findAll();
			for (int i = 0; i < list.size(); i++) {
				System.out.println("	-" + list.get(i));
			}
			System.out.println();
			
			
		};
	}
	
	public static String revert(String s) {

		s = s.replaceAll("%C3%84", "Ä");
		s = s.replaceAll("%C3%9C", "Ü");
		s = s.replaceAll("%C3%96", "Ö");
		
		s = s.replaceAll("%C3%A4", "ä");
		s = s.replaceAll("%C3%BC", "ü");
		s = s.replaceAll("%C3%B6", "ö");
		
		return s;
	}
	
}
