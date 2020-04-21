package io.abolanos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.abolanos.domain.Item;
import io.abolanos.item.ItemRepository;

@SpringBootApplication
public class AdvjavaFinalGuiApplication {
	
	@Autowired
	ItemRepository itemRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(AdvjavaFinalGuiApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner() {
	
		return args -> {
			
			// Create items manually.
			
			Item item1 = new Item("Finish the project", true);
			Item item2 = new Item("Do the dishes", false);
			Item item3 = new Item("Cut my hair", false);
			
			// Save items to the database.
			itemRepo.save(item1);
			itemRepo.save(item2);
			itemRepo.save(item3);
			
		};
	}
	

}