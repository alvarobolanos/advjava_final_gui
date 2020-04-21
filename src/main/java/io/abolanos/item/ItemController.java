package io.abolanos.item;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import io.abolanos.domain.Item;

@Controller
public class ItemController {
	
	@Autowired
	ItemRepository itemRepo;
	
	@Autowired																	// Connects itemService with the main controller.
	ItemService itemService;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Item> items = itemService.getAllItems();
		model.addAttribute("itemsList", items);
		return "index";	
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("item", new Item());
		return "create";	
	}
	
	@PostMapping("/save")
	public String save(Item item) {
		itemRepo.save(item);
		return "save";
	}
	
	@GetMapping("/completed")
	public String completed(Model model) {
		List<Item> completedItems = itemService.getComplete();
		model.addAttribute("itemsList", completedItems);
		return "completed";
	}
	
	@GetMapping("/todo")
	public String todo(Model model) {
		List<Item> todoItems = itemService.getNonComplete();
		model.addAttribute("itemsList", todoItems);
		return "todo";
	}
	
	@GetMapping("/sorted")
	public String sorted(Model model) {
		List<Item> toDoItems = itemService.getAllItemsSorted();
		model.addAttribute("itemsList", toDoItems);
		return "sorted";
	}
	
	@GetMapping("/shuffled")
	public String shuffled(Model model) {
		List<Item> toDoItems = itemService.getAllItemsShuffled();
		model.addAttribute("itemsList", toDoItems);
		return "shuffled";
	}
	
	@GetMapping("/item/{id}")
	public String itemDetail(Model model, @PathVariable Long id) {
		Optional<Item> item = itemRepo.findById(id);
		model.addAttribute("item", item);
		return "item-detail";
	}
	

}
