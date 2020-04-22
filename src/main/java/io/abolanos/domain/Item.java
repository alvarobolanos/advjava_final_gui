package io.abolanos.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity													// Annotation for Hibernate to identify as an entity.
public class Item {

	@Id													// ID annotation for Hibernate to manage.
	@GeneratedValue (strategy = GenerationType.AUTO)	// Strategy delegates to db to create and maintain the id. It's a fast strategy however IDENTITY may prove better if seeding with non sequential ids. Identity may slow app down when batch creating a large amount of records.
	private Long id;									// Stores an auto-generated long value as an id in the database.
	
	private String description;							// Stores the description of the todo item.
	
	private Boolean completed;							// Flag for the status of the todo item.
	
	@CreationTimestamp									// Autogenerates creation date stamp.
	private LocalDateTime createDateTime;				
	
	@UpdateTimestamp									// Autogenerates and maintains update date stamp.
	private LocalDateTime updateDateTime;				
	
	public Item() {										// Empty constructor for item initialization.
		
	}
	
	public Item(String description) {					// Overloaded constructor with description parameter and false for completed boolean as default.
		super();
		this.description = description;
		this.setCompleted(false);
	}
	

	// TODO: could modify this constructor to include dates parameters to seed database with a data.sql file rather than autorunner.
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
	
	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
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

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
		
}
