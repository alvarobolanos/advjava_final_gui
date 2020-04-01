package io.abolanos.item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service																		// Annotation to set Service class.
public class ItemService {
	
	private List<Item> items = new ArrayList <>(Arrays.asList( 					// Creating an Array List of items in line.
			new Item("Do Springboot homework"),
			new Item("Have dinner", true),
			new Item("Sleep", false),
			new Item("Act", true)));
	
	public List<Item> getAllItems() {											// Method to return a List<Item> items.
		return items;
	}
	
	public List<Item> getAllItemsSorted() {										// Method to return a sorted List<Item> items.
		Collections.sort(items, (a, b) -> a.getDescription().compareTo(b.getDescription()));	// Use the Collections' sort method with a lambda function to compare descriptions given two description of the items.
		return items;
	}
	
	public List<Item> getAllItemsShuffled() {									// Method to return a shuffled List<Item> items.
		Collections.shuffle(items);												// Use of Collections' shuffle method to shuffle the items.
		return items;
	}
	
	public List<Item> SortItems(List<Item> itemList) {							// General method to sort any List<Item>. Intended to sort filtered lists but didn't get to it.
		Collections.sort(itemList, (a, b) -> a.getDescription().compareTo(b.getDescription()));
		return itemList;
	}
	
	public Item getItem(String description) {									// Method to return an individual first occurrence of the item based on it's description match.
		return items.stream().filter(i -> i.getDescription().equalsIgnoreCase(description)).findFirst().get();		// Use of a stream filter where given an item, it locates and returns the first instance of a matched description.
	}
	
	public List<Item> getNonComplete() {										// Method to return non completed items.
		return items.stream().filter(i -> i.getCompleted().equals(false)).collect(Collectors.toList());				// Use of a stream filter where a list of non completed items is returned.
	}
	
	
	public List<Item> getComplete() {											// Method to return non completed items.
		return items.stream().filter(i -> i.getCompleted().equals(true)).collect(Collectors.toList());				// Use of a stream filter where a list of completed items is returned.
	}
	
	 public void addItem(Item item) {											// Method to add an item.
		items.add(item);														// Adds an item to the List<Item> items.
	}

	public void completeItem(String description, Item item) {					// Helper function to replace an item's payload using postman.

		//for easy postman manipulation.
		for (int i = 0; i < items.size(); i++) {								// Step through the List<Item> items list.
			Item tempItem = items.get(i);
			if (tempItem.getDescription().equalsIgnoreCase(description)) {		// Upon finding an item with the description in the parameter,
				items.set(i, item);												// then, set it to the item passed as argument (makes for easy payload modification in postman).
				return;
			}
		}
		
//		Potential enhanced loop to simply set the completed flag to true. Not tested.
//		for (Item tempItem: items) {
//			if (tempItem.getDescription().equalsIgnoreCase(description)) {
//				tempItem.setCompleted(true);
//			}
//		}
		
	}

	public void deleteItem(String description) {								// Method to delete an item from List<Item> items.
		items.removeIf(i -> i.getDescription().equalsIgnoreCase(description));	// Use of a lambda expression with removeIf method for a given item i which matches the description passed as argument.
	}

}
