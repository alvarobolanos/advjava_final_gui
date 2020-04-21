package io.abolanos.item;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.abolanos.domain.Item;

public interface ItemRepository extends CrudRepository<Item, Long>{
	
	public List<Item> findByCompleted(Boolean completed);

	
}
