package io.abolanos.item;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.abolanos.domain.Item;

@Controller
public class ItemController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";	
	}
	
	@RequestMapping(value = "/createNewItem", method = RequestMethod.GET)
	public String processNewItem(Model model) {
		model.addAttribute("newItemData", new Item());
		return "createNewItem";	
	}
	

}
