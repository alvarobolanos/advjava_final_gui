package io.abolanos.item;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long>{
	
	public List<Item> findByCompleted(Boolean completed);
	
}
