package io.abolanos.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import io.abolanos.domain.Item;

@Controller
public class ItemController {
	
	@Autowired
	ItemRepository itemRepo;
	
	@GetMapping("/")
	public String index() {
		return "index";	
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("item", new Item());
		return "create";	
	}
	
	@PostMapping("/save")
	public String save(Item item, Model model) {
		itemRepo.save(item);
		
		return "save";
	}
	

}
