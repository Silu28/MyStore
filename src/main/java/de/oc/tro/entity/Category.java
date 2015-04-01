package de.oc.tro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	
	// ======================================
	// =             Attributes             =
	// ======================================
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	// ======================================
	// =             Constructors           =
	// ======================================
	
	public Category() {
		super();
	}

	public Category(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	// ======================================
	// =             Getter/Setter          =
	// ======================================

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// ======================================
	// =             toString               =
	// ======================================
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description="
				+ description + "]";
	}
	
}
