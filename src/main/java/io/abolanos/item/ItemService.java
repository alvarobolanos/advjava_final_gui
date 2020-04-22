package io.abolanos.item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.abolanos.domain.Item;

@Service																		// Annotation to set Service class.
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	//CRUD Logic
	
	public void addItem(Item item) {											// Method to add an item record in the database.
		itemRepository.save(item);												// Adds an item to the database.
	}
	
	public void updateItem(Long id, Item item) {								// Method to update an item record in the database.
		
		Optional <Item> itemOptional = itemRepository.findById(id);
		if (itemOptional.isPresent()) {
			item.setId(id);														// Sets the id on the item to avoid creating a new one.
			itemRepository.save(item);											// Saves over the identified item or creates a new item record in the database if description is not found.			
		}
	}
	
	// TODO: Find a better way to retain values when updating.
	public void markComplete(Long id, Item item) {
		
		Optional <Item> queryItem = itemRepository.findById(id);
		if (queryItem.isPresent()) {											// If queried item is found then,
			Item foundItem = queryItem.get();									// Convert the optional queryItem into a found item.
			item.setCompleted(true);											// Sets the completed flag to true.
			item.setDescription(foundItem.getDescription());					// Retains the description.
			item.setCreateDateTime(foundItem.getCreateDateTime());				// Retains the create timestamp.
			itemRepository.save(item);											// Saves over the identified item or creates a new item record in the database if description is not found.			
		}
	}
	
	// TODO: Find a better way to retain values when updating.
	public void markToDo(Long id, Item item) {
		
		Optional <Item> queryItem = itemRepository.findById(id);
		if (queryItem.isPresent()) {											// If queried item is found then,
			Item foundItem = queryItem.get();									// Convert the optional queryItem into a found item.
			item.setCompleted(false);											// Sets the completed flag to false.
			item.setDescription(foundItem.getDescription());					// Retains the description.
			item.setCreateDateTime(foundItem.getCreateDateTime());				// Retains the create timestamp.
			itemRepository.save(item);											// Saves over the identified item or creates a new item record in the database if description is not found.			
		}
	}
	
	// TODO: Find a better way to retain values when updating.
		public void editItem(Long id, Item item) {
			
			Optional <Item> queryItem = itemRepository.findById(id);
			if (queryItem.isPresent()) {											// If queried item is found then,
				Item foundItem = queryItem.get();									// Convert the optional queryItem into a found item.
				item.setCompleted(false);											// Sets the completed flag to false.
				item.setDescription(foundItem.getDescription());					// Retains the description.
				item.setCreateDateTime(foundItem.getCreateDateTime());				// Retains the create timestamp.
				itemRepository.save(item);											// Saves over the identified item or creates a new item record in the database if description is not found.			
			}
		}
	
	public void deleteItem(Long id) {
		itemRepository.deleteById(id);
	}
	
	public void deleteAllItems() {
		itemRepository.deleteAll();
	}
	
	// Getters
	
	public Optional<Item> getItem(Long id) {									// Method to return an individual first occurrence of the item based on it's description match.
		return itemRepository.findById(id);
	}
	
	public List<Item> getAllItems() {											// Method to return items in the db.
		List<Item> items = new ArrayList<> ();									// Instantiates an inferred generic ArrayList from List<Items> parameterized class.
		itemRepository.findAll().forEach(items::add);							// Connect to db, run a query and retrieve an iterable with a row per each record. Then adds each one to the items ArrayList.
		return items;
	}
	
	public List<Item> getAllItemsSorted() {										// Method to return a sorted List<Item> items.	
		List <Item> sortedItems = getAllItems();								// Temporary List<Item> populated by the getAllItems() method.
		Collections.sort(sortedItems, (a, b) -> a.getDescription().compareTo(b.getDescription())); // Use the Collections' sort method with a lambda function to compare descriptions given two description of the items.		
		return sortedItems;
	}

	public List<Item> getAllItemsShuffled() {									// Method to return a shuffled List<Item> items.
		List<Item> shuffledItems = getAllItems();								// Temporary List<Item> populated by the getAllItems() method
		Collections.shuffle(shuffledItems);										// Use of Collections' shuffle method to shuffle the items.
		return shuffledItems;
	}
	
	public List<Item> getNonComplete() {										// Method to return non completed items.
		return itemRepository.findByCompleted(false);							// Use of a stream filter where a list of non completed items is returned.
	}

	public List<Item> getComplete() {											// Method to return non completed items.
		return itemRepository.findByCompleted(true);							// Use of a stream filter where a list of completed items is returned.
	}


}
