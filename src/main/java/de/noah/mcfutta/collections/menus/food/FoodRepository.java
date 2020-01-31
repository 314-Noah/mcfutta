package de.noah.mcfutta.collections.menus.food;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface FoodRepository extends MongoRepository<Food, String> {

	@Query("{ 'name' : ?0}")
	public Food getByName(String name);
	
}
