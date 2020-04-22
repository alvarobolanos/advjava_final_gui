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

@Controller																		// Annotation denoting a controller in the MVC.
public class ItemController {
	
	@Autowired																	// Autowires an itemRepo when called.
	ItemRepository itemRepo;
	
	@Autowired																	// Autowires an itemService when called. Connects itemService with the item controller.
	ItemService itemService;
	
	@GetMapping("/")															// Sets end point for the get request.
	public String index(Model model) {											// Pass in an instance of the model to pass information to the page.
		List<Item> completedItems = itemService.getComplete();					// Get a list of completed items.
		List<Item> todoItems = itemService.getNonComplete();					// Get a list of todo items.
		model.addAttribute("completedItemsList", completedItems);				// Add list of completed items to the model as attribute. Key Value pair.
		model.addAttribute("todoItemsList", todoItems);							// Add list of todo items to the model as attribute. Key Value pair.
		return "index";															// Return the index.html template.
	}
	
	@GetMapping("/create")														// Sets end point for the get request.
	public String create(Model model) {											// Pass in an instance of the model to pass information to the page.
		model.addAttribute("item", new Item());									// Add a new items to the model as attribute. Key Value pair.
		return "create";														// Return the create.html template.
	}
	
	@PostMapping("/save")														// Sets end point for the Post request.
	public String save(Item item) {												// Takes an item as parameter.
		item.setCompleted(false);												// Sets the completed field as false.
		itemRepo.save(item);													// Saves the item to db using the repository interface.
		return "save";															// Returns the save.html template.
	}
	
	@GetMapping("/completed")													// Sets end point for the get request.
	public String completed(Model model) {										// Pass in an instance of the model to pass information to the page.
		List<Item> completedItems = itemService.getComplete();					// Gets a list of completed items using the itemService custom method.
		model.addAttribute("itemsList", completedItems);						// Adds the list of items to the model as attribute. Key Value pair.
		return "completed";														// returns the completed.html template.
	}
	
	@GetMapping("/todo")														// Same as above but:
	public String todo(Model model) {
		List<Item> todoItems = itemService.getNonComplete();					// Gets a list of completed items using the itemService custom method.
		model.addAttribute("itemsList", todoItems);
		return "todo";
	}
	
	@GetMapping("/sorted")														// Same as above but: 
	public String sorted(Model model) {
		List<Item> toDoItems = itemService.getAllItemsSorted();					// Gets a list of all items and sorts them alphabetically by description field.
		model.addAttribute("itemsList", toDoItems);
		return "sorted";
	}
	
	@GetMapping("/shuffled")													// Same as above but:
	public String shuffled(Model model) {
		List<Item> toDoItems = itemService.getAllItemsShuffled();				// Gets a list of all items shuffles them. Collections.shuffle(List).
		model.addAttribute("itemsList", toDoItems);
		return "shuffled";
	}
	
	@GetMapping("/view/item/{id}")												// Sets end point for the get request. Includes a path variable {}
	public String itemDetail(Model model, @PathVariable Long id) {				// Expects the Model model and a @PathVariable 
		Optional<Item> queryItemDetail = itemRepo.findById(id);					// Queries the database to ensure an item with such id exists.
		if(queryItemDetail.isPresent()) {										// If the item exists then,
			Item itemDetail = queryItemDetail.get();							// Convert to an Item type object,
			model.addAttribute("itemDetail", itemDetail);						// Pass the information to the template through the model
			return "item-detail";												// Return the item-detail template.
		} else {
			return "redirect:/error/404";										// return 404 error template if item id is not found.									
		}
	}
	
	@GetMapping("/mark/complete/item/{id}")
	public String markComplete(@PathVariable Long id, Item item) {
		itemService.markComplete(id, item);
		return "redirect:/";
	}
	
	@GetMapping("/mark/todo/item/{id}")
	public String markToDo(@PathVariable Long id, Item item) {
		itemService.markToDo(id, item);
		return "redirect:/";
	}
	
	@GetMapping("/delete/item/{id}")
	public String deleteItem(@PathVariable Long id) {
		itemService.deleteItem(id);
		return "redirect:/";
	}
	
	@GetMapping("/edit/item/{id}")
	public String editItem(@PathVariable Long id, Model model) {
		Optional<Item> queryItemEdit = itemRepo.findById(id);	 
		if(queryItemEdit.isPresent()) {
			Item item = queryItemEdit.get();
			model.addAttribute("item", item);
			return "edit";
		} else {
			return "redirect:/error/404";
		}
	}
	
	@PostMapping("/update")
	public String updateItem(@PathVariable Long id, Item item, Model model) {
		
		return "redirect:/view/item/{id}";
	}
	
	

}
