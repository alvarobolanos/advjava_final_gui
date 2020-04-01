package io.abolanos.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin																	// Avoids CrossOrigin error.
@RestController																	// Annotation for Class to be Rest Controller
public class ItemController {
	
	@Autowired																	// Connects itemService with the main controller.
	private ItemService itemService;
	
	@RequestMapping({"todolist", "todolist/all"})												// URL request mapping to control.
	public List<Item> getAllItems() {											// Method that calls the corresponding service in itemService.
		return itemService.getAllItems();
	}
	
	@RequestMapping("todolist/sorted")										// URL request mapping to control.
	public List<Item> getAllItemsSorted() {										// Method that calls the corresponding service in itemService.
		return itemService.getAllItemsSorted();
	}
	
	@RequestMapping("todolist/shuffled")									// URL request mapping to control.
	public List<Item> getAllItemsShuffled() {									// Method that calls the corresponding service in itemService.
		return itemService.getAllItemsShuffled();								
	}
	
	@RequestMapping("todolist/todo")											// URL request mapping to control.
	public List<Item> getNonComplete() {										// Method that calls the corresponding service in itemService.
		return itemService.getNonComplete();
	}
	
	@RequestMapping("todolist/complete")										// URL request mapping to control.
	public List<Item> getComplete() {											// Method that calls the corresponding service in itemService.
		return itemService.getComplete();
	}
	
	@RequestMapping("todolist/{description}")									// URL request mapping to control.
	public Item getItem(@PathVariable String description) {						// Method that calls the corresponding service in itemService.
		return itemService.getItem(description);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "todolist")			// URL request mapping to control. Usable for creating a new item.
	public void addItem(@RequestBody Item item) {								// Method that calls the corresponding service in itemService.
		itemService.addItem(item);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "todolist/complete/{description}")	// URL request mapping to control. Usable for updating an item.
	public void completeItem(@RequestBody Item item, @PathVariable String description) {	// Method that calls the corresponding service in itemService.
		itemService.completeItem(description, item);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "todolist/delete/{description}")	// URL request mapping to control. Usable for deleting an item.
	public void deleteItem(@PathVariable String description) {								// Method that calls the corresponding service in itemService.
		itemService.deleteItem(description);
	}
	
}		// End ItemController.java


