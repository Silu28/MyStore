package de.oc.tro.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private double price;

	@Column(name = "ingredients")
	private Set<String> ingredients = new HashSet<String>();

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "country_fk")
	private Country country;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "category_fk")
	private Category category;

	public Product() {
		super();
	}

	public Product(String name, String description, double price,
			Set<String> ingredients, Country country, Category category) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.ingredients = ingredients;
		this.country = country;
		this.category = category;
	}

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Set<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<String> ingredients) {
		this.ingredients = ingredients;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description="
				+ description + ", price=" + price + ", ingredients="
				+ ingredients + ", country=" + country + "]";
	}

}
