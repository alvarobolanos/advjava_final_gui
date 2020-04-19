package io.abolanos.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
public class Item {

	@Id	
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;									// Stores an auto-generated long value as an id in the database.
	
	private String description;							// Stores the description of the todo item.
	
	private Boolean completed;							// Flag for the status of the todo item.
	
	@CreationTimestamp
	private LocalDateTime createDateTime;
	
	@UpdateTimestamp
	private LocalDateTime updateDateTime;
	
	public Item() {										// Empty constructor for item initialization.
		
	}
	
	public Item(String description) {					// Overloaded constructor with description parameter and false for completed boolean as default.
		super();
		this.description = description;
		this.setCompleted(false);
	}
	

	public Item(String description, Boolean status) {	// Constructor for Item.
		super();
		this.description = description;
		this.setCompleted(status);
	}
	
	// Getters
	
	public Long getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}

	public Boolean getCompleted() {
		return completed;
	}
	

	// Setters
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	
}
